package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.integration.JobRuntime;
import com.unep.wcmc.model.*;
import com.unep.wcmc.service.SpeciesPlusService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
                                family, genus, null, null);
                        // create the taxonomy data
                        Taxonomy taxonomy = new Taxonomy();
                        taxonomy.setHierarchy(hierarchy);
                        // create the species data
                        Species species = new Species();
                        species.setTaxonomy(taxonomy);
                        species.setScientificName(String.valueOf(taxon.get("full_name")));
                        List<Map<String, Object>> commonNames = (List<Map<String, Object>>) taxon.get("common_names");
                        if (commonNames != null && !commonNames.isEmpty()) {
                            species.setCommonName(String.valueOf(commonNames.get(0).get("name")));
                        }
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
