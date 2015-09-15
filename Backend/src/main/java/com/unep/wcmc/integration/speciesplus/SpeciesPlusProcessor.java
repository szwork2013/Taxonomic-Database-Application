package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.integration.JobRuntime;
import com.unep.wcmc.model.*;
import com.unep.wcmc.service.SpeciesPlusService;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Map;

@Component
@SuppressWarnings("all")
public class SpeciesPlusProcessor implements ItemProcessor<Map<String, Object>, Species> {

    protected static final Log logger = LogFactory.getLog(SpeciesPlusProcessor.class);

    @Autowired
    private JobRunner jobRunner;

    @Autowired
    private SpeciesPlusService speciesPlusService;

    @Override
    public Species process(Map<String, Object> item) throws Exception {
        return processSpecies(item);
    }

    /**
     * Process and parse the Species data from Species+ API to Species object
     * @param taxon
     * @return
     */
    private Species processSpecies(Map<String, Object> taxon) {
        try {
            SpeciesPlusService.SpeciesPlusRank rank = SpeciesPlusService.SpeciesPlusRank.valueOf(
                    String.valueOf(taxon.get("rank")));
            if (rank == SpeciesPlusService.SpeciesPlusRank.GENUS) {
                processGenus(taxon);
            } else {
                if (isBrazilianSpecies(taxon)) {
                    Map<String, Object> higherTaxa = (Map<String, Object>)
                            taxon.get("higher_taxa");
                    if (higherTaxa != null) {

                        // create the kingom, phylum, class, order, family, genus, hierarchy data
                        Kingdom kingdom = String.valueOf(higherTaxa.get("kingdom")).equalsIgnoreCase("null") ? null :
                                new Kingdom(String.valueOf(higherTaxa.get("kingdom")));
                        Phylum phylum = String.valueOf(higherTaxa.get("phylum")).equalsIgnoreCase("null") ? null :
                                new Phylum(String.valueOf(higherTaxa.get("phylum")));
                        HierarchyClass hierarchyClass = String.valueOf(higherTaxa.get("class")).equalsIgnoreCase("null") ? null :
                                new HierarchyClass(String.valueOf(higherTaxa.get("class")));
                        HierarchyOrder hierarchyOrder = String.valueOf(higherTaxa.get("order")).equalsIgnoreCase("null") ? null :
                                new HierarchyOrder(String.valueOf(higherTaxa.get("order")));
                        Family family = String.valueOf(higherTaxa.get("family")).equalsIgnoreCase("null") ? null :
                                new Family(String.valueOf(higherTaxa.get("family")));
                        Genus genus = String.valueOf(higherTaxa.get("genus")).equalsIgnoreCase("null") ? null :
                                new Genus(String.valueOf(higherTaxa.get("genus")));
                        Hierarchy hierarchy = new Hierarchy(kingdom, phylum, hierarchyClass, hierarchyOrder,
                                family, genus, null);
                        // create the taxonomy data
                        Taxonomy taxonomy = new Taxonomy();
                        taxonomy.setHierarchy(hierarchy);
                        // create the species data
                        Species species = new Species();
                        species.setTaxonomy(taxonomy);
                        species.setName(String.valueOf(taxon.get("full_name")));
                        species.setScientificName(String.valueOf(taxon.get("full_name")));

                        // processing the Common Names
                        List<Map<String, Object>> commonNames = (List<Map<String, Object>>) taxon.get("common_names");
                        if (commonNames != null && !commonNames.isEmpty()) {
                            Set<CommonName> commonNameList = new HashSet<>();
                            for (Map<String, Object> commonName : commonNames) {
                                commonNameList.add(new CommonName(String.valueOf(commonName.get("name"))));
                            }
                            taxonomy.setCommonNames(commonNameList);
                        }
                        // processing the Synonyms
                        List<Map<String, Object>> synonyms = (List<Map<String, Object>>) taxon.get("synonyms");
                        if (synonyms != null && !synonyms.isEmpty()) {
                            Set<Synonym> synonymList = new HashSet<>();
                            for (Map<String, Object> synonym : synonyms) {
                                Synonym s = new Synonym();
                                s.setSynonym(String.valueOf(synonym.get("full_name")));
                                s.setAuthor(String.valueOf(synonym.get("author_year")));
                                synonymList.add(s);
                            }
                            taxonomy.setSynonyms(synonymList);
                        }
                        // processing the Cities Listings
                        List<Map<String, Object>> citesListings = (List<Map<String, Object>>)
                                taxon.get("cites_listings");
                        if (citesListings != null) {
                            Set<Appendix> appendixList = new HashSet<>();
                            for (Map<String, Object> appendix : citesListings) {
                                Appendix app = new Appendix();
                                app.setType(String.valueOf(appendix.get("appendix")));
                                app.setAnnotation(String.valueOf(appendix.get("annotation")));
                                app.setHashAnnotation(String.valueOf(appendix.get("hash_annotation")));
                                appendixList.add(app);
                            }
                            species.setAppendixes(appendixList);
                        }

                        Conservation conservation = new Conservation();
                        conservation.setConventions(processConventions(taxon));
                        conservation.setExtinctionRisk(processOtherListsEndangeredSpecies(taxon));
                        species.setConservation(conservation);

                        return species;
                    }
                }
            }
            return null;
        } catch (Exception ex) {
            logger.error("Error processing Species+ API data.", ex);
            throw new RuntimeException(ex);
        }
    }

    private void processGenus(Map<String, Object> taxon) {
        JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.SPECIES_PLUS.name());
        List<Genus> genusList = (List<Genus>) runtime.getVariables().get("genus");
        if (genusList == null) {
            genusList = new ArrayList<>();
            runtime.getVariables().put("genus", genusList);
        }
        genusList.add(new Genus(String.valueOf(taxon.get("full_name"))));
    }

    private Conventions processConventions(Map<String, Object> taxon) {
        Conventions conventions = new Conventions();

        String id = taxon.get("id") != null ? String.valueOf(taxon.get("id")) : "-1";
        Map<String, Object> citiesLegislation =
                speciesPlusService.getTaxonCitiesLegislation(Long.parseLong(id));
        if (citiesLegislation != null) {
            List<ConventionItem> conventionList = new ArrayList<>();

            // processing Cites Listings
            List<Map<String, Object>> citesListings = (List<Map<String, Object>>)
                    taxon.get("cites_listings");
            for (Map<String, Object> cite : citesListings) {
                Map<String, Object> party = (Map<String, Object>) cite.get("party");
                if ("BR".equals(String.valueOf(party.get("iso_code2")))) {
                    ConventionItem item = new ConventionItem();
                    item.setName(String.valueOf(cite.get("appendix")));
                    try {
                        Date date = DateUtils.parseDate(String.valueOf(cite.get("effective_at")),
                                new String[]{"yyyy-MM-dd"});
                        item.setYear(date.getYear() + 1900);
                    } catch (Exception ex) {
                        item.setYear(null);
                    }
                    item.setObservation(String.valueOf(cite.get("annotation")));
                    conventionList.add(item);
                }
            }

            // processing Cites Quotas
            List<Map<String, Object>> citesQuotas = (List<Map<String, Object>>)
                    taxon.get("cites_quotas");
            for (Map<String, Object> cite : citesQuotas) {
                Map<String, Object> geoEntity = (Map<String, Object>) cite.get("geo_entity");
                if ("BR".equals(String.valueOf(geoEntity.get("iso_code2")))) {
                    ConventionItem item = new ConventionItem();
                    item.setName(String.valueOf(cite.get("quota")));
                    try {
                        Date date = DateUtils.parseDate(String.valueOf(cite.get("publication_date")),
                                new String[]{"yyyy-MM-dd"});
                        item.setYear(date.getYear() + 1900);
                    } catch (Exception ex) {
                        item.setYear(null);
                    }
                    item.setObservation(String.valueOf(cite.get("notes")));
                    conventionList.add(item);
                }
            }

            // processing Cites Suspensions
            List<Map<String, Object>> citesSuspensions = (List<Map<String, Object>>)
                    taxon.get("cites_suspensions");
            for (Map<String, Object> cite : citesSuspensions) {
                Map<String, Object> geoEntity = (Map<String, Object>) cite.get("geo_entity");
                if ("BR".equals(String.valueOf(geoEntity.get("iso_code2")))) {
                    ConventionItem item = new ConventionItem();
                    item.setName(String.valueOf(cite.get("name")));
                    try {
                        Date date = DateUtils.parseDate(String.valueOf(cite.get("start_date")),
                                new String[]{"yyyy-MM-dd"});
                        item.setYear(date.getYear() + 1900);
                    } catch (Exception ex) {
                        item.setYear(null);
                    }
                    item.setObservation(String.valueOf(cite.get("notes")));
                    conventionList.add(item);
                }
            }
            conventions.setConventionItems(conventionList);
        }
        return conventions;
    }

    private ExtinctionRisk processOtherListsEndangeredSpecies(Map<String, Object> taxon) {
        ExtinctionRisk extinctionRisk = new ExtinctionRisk();

        String id = taxon.get("id") != null ? String.valueOf(taxon.get("id")) : "-1";
        Map<String, Object> citiesLegislation =
                speciesPlusService.getTaxonCitiesLegislation(Long.parseLong(id));
        if (citiesLegislation != null) {
            List<ExtinctionRiskAssessment> assessmentList = new ArrayList<>();
            // processing Cites Listings
            List<Map<String, Object>> citesListings = (List<Map<String, Object>>)
                    taxon.get("cites_listings");
            for (Map<String, Object> cite : citesListings) {
                Map<String, Object> party = (Map<String, Object>) cite.get("party");
                if (!"BR".equals(String.valueOf(party.get("iso_code2")))) {
                    ExtinctionRiskAssessment riskAssessment = new ExtinctionRiskAssessment();
                    // TODO: Add this new state field? Ask to Thomas about it
                    //riskAssessment.setState(String.valueOf(party.get("iso_code2")));
                    riskAssessment.setCategory(String.valueOf(cite.get("appendix")));
                    try {
                        Date date = DateUtils.parseDate(String.valueOf(cite.get("effective_at")),
                                new String[]{"yyyy-MM-dd"});
                        riskAssessment.setYear(date.getYear() + 1900);
                    } catch (Exception ex) {
                        riskAssessment.setYear(null);
                    }
                    riskAssessment.setCriteria("CITES listings");
                    riskAssessment.setJustification(String.valueOf(cite.get("annotation")));
                    assessmentList.add(riskAssessment);
                }
            }
            extinctionRisk.setOtherListsAssessments(assessmentList);
        }
        return extinctionRisk;
    }

    /**
     * Validate if the current Species data is a brazilian species
     * @param taxon
     * @return
     */
    private boolean isBrazilianSpecies(Map<String, Object> taxon) {
        String id = taxon.get("id") != null ? String.valueOf(taxon.get("id")) : "-1";
        List<Object> distributions = speciesPlusService.getTaxonDistributions(Long.parseLong(id));
        for (Object dist : distributions) {
            Map<String, Object> item = (Map<String, Object>) dist;
            if ("BR".equals(String.valueOf(item.get("iso_code2")))) {
                return true;
            }
        }
        return false;
    }

}