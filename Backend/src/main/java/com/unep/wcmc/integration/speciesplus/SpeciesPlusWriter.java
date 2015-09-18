package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.integration.JobRuntime;
import com.unep.wcmc.model.*;
import com.unep.wcmc.service.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.unep.wcmc.integration.JobRuntime.JobVariable.EXCEPTIONS_COUNT;
import static com.unep.wcmc.integration.JobRuntime.JobVariable.UPDATES_COUNT;

@Component
@SuppressWarnings("all")
public class SpeciesPlusWriter implements ItemWriter<Species> {

    @Autowired
    private JobRunner jobRunner;

    @Autowired
    private KingdomService kingdomService;

    @Autowired
    private PhylumService phylumService;

    @Autowired
    private HierarchyClassService classService;

    @Autowired
    private HierarchyOrderService orderService;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private GenusService genusService;

    @Autowired
    private TaxonomyService taxonomyService;

    @Autowired
    private SpeciesService speciesService;

    private boolean raiseException;

    @Override
    public void write(List<? extends Species> items) throws Exception {
        for (Species species : items) {
            raiseException = false;

            // verifying if the species already exists and updates if true
            //Species existing = speciesService.findByScientificName(species.getScientificName());

            // NOTE: temporary using the species name as JOIN condition (requested by Thomas WCMC)
            Species existing = speciesService.findByCommonName(species.getScientificName());
            if (existing != null) {
                updateExistingSpecies(species, existing);
            } else {
                saveNewSpecies(species);
            }
        }
    }

    private Species updateExistingSpecies(Species species, Species existing) {
        JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.SPECIES_PLUS.name());
        UPDATES_COUNT.increment(runtime);
        // set the values to update
        existing.setName(species.getName());
        //existing.setScientificName(species.getScientificName()); // TODO ask Thomas if that should be updated?
        existing.setEnabled(true);

        Taxonomy taxonomy = existing.getTaxonomy();
        // add common names
        if (species.getTaxonomy().getCommonNames() != null) {
            if (taxonomy.getCommonNames() != null) {
                taxonomy.getCommonNames().addAll(species.getTaxonomy().getCommonNames());
            } else {
                taxonomy.setCommonNames(species.getTaxonomy().getCommonNames());
            }
        }
        // add synomyns
        if (species.getTaxonomy().getSynonyms() != null) {
            if (taxonomy.getSynonyms() != null) {
                taxonomy.getSynonyms().addAll(species.getTaxonomy().getSynonyms());
            } else {
                taxonomy.setSynonyms(species.getTaxonomy().getSynonyms());
            }
        }
        // add appendixes and conservation data imported
        if (species.getAppendixes() != null) {
            if (existing.getAppendixes() != null) {
                existing.getAppendixes().addAll(species.getAppendixes());
            } else {
                existing.setAppendixes(species.getAppendixes());
            }
        }
        // add conservation
        if (existing.getConservation() != null) {
            Conservation conservation = existing.getConservation();
            // add the other lists of assesments
            if (species.getConservation().getExtinctionRisk() != null) {
                if (conservation.getExtinctionRisk() != null) {
                    if (conservation.getExtinctionRisk().getOtherListsAssessments() != null) {
                        conservation.getExtinctionRisk().getOtherListsAssessments().addAll(
                                species.getConservation().getExtinctionRisk().getOtherListsAssessments());
                    } else {
                        conservation.getExtinctionRisk().setOtherListsAssessments(
                                species.getConservation().getExtinctionRisk().getOtherListsAssessments());
                    }
                } else {
                    conservation.setExtinctionRisk(species.getConservation().getExtinctionRisk());
                }
            }
            // add the conventions items data
            if (species.getConservation().getConventions() != null) {
                if (conservation.getConventions() != null) {
                    if (conservation.getConventions().getConventionItems() != null) {
                        conservation.getConventions().getConventionItems().addAll(
                                species.getConservation().getConventions().getConventionItems());
                    } else {
                        conservation.getConventions().setConventionItems(
                                species.getConservation().getConventions().getConventionItems());
                    }
                } else {
                    conservation.setConventions(species.getConservation().getConventions());
                }
            }
        } else {
            existing.setConservation(species.getConservation());
        }
        // save the species data
        return speciesService.doSave(existing);
    }

    private Species saveNewSpecies(Species species) {
        JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.SPECIES_PLUS.name());
        // validating if there are similar species in the database
        //List<Species> similaries = speciesService.findByScientificNameSimilaries(species.getScientificName());

        // NOTE: only processing Fauna species at this time
        species.setType(Species.SpeciesType.FAUNA);

        // Validate the --NEW-- Species taxonomy to be persisted
        validateTaxonomy(species);

        // NOTE: temporary using the species name as JOIN condition (requested by Thomas WCMC)
        List<Species> similaries = speciesService.findBySpeciesNameSimilaries(species.getScientificName());
        if (similaries != null && !similaries.isEmpty()) {
            EXCEPTIONS_COUNT.increment(runtime);
            species.setType(similaries.get(0).getType());
            species.setEnabled(false);
            species = speciesService.doSave(species);
            speciesService.raiseSpeciesException(similaries.get(0), species,
                    ExceptionOccurrence.Severity.MAJOR, IntegrationSource.Source.SPECIES_PLUS);
            return species;
        } else {
            EXCEPTIONS_COUNT.increment(runtime);
            species.setEnabled(false);
            species = speciesService.doSave(species);
            speciesService.raiseSpeciesException(species, species,
                    ExceptionOccurrence.Severity.MAJOR, IntegrationSource.Source.SPECIES_PLUS);
            return species;
        }
    }

    private void validateTaxonomy(Species species) {
        Taxonomy taxonomy = species.getTaxonomy();
        Hierarchy hierarchy = validateHierarchy(taxonomy.getHierarchy(), species);
        taxonomy.setHierarchy(hierarchy);
        // validate if the taxonomy data exists on the database
        List<Taxonomy> taxonomyList = taxonomyService.findByHierarchy(taxonomy);
        if (taxonomyList == null || taxonomyList.isEmpty()) {
            taxonomy.setEnabled(false);
            taxonomy.setLastModified(new Date());
            taxonomyService.save(taxonomy);
        } else {
            taxonomy = taxonomyList.get(0);
        }
        species.setTaxonomy(taxonomy);
    }

    private Hierarchy validateHierarchy(Hierarchy hierarchy, Species species) {
        // validate if the hierarchy data exists on the database
        Kingdom kingdom = null;
        if (hierarchy.getKingdom() != null) {
            kingdom = kingdomService.findByName(hierarchy.getKingdom().getName());
            if (kingdom == null) {
                kingdom = kingdomService.save(hierarchy.getKingdom());
                raiseException = true;
            }
        }
        // process the phylum data
        Phylum phylum = null;
        if (hierarchy.getPhylum() != null) {
            phylum = phylumService.findByName(hierarchy.getPhylum().getName());
            if (phylum == null) {
                phylum = phylumService.save(hierarchy.getPhylum());
                raiseException = true;
            }
        }
        // process the class data
        HierarchyClass hierarchyClass = null;
        if (hierarchy.getHierarchyClass() != null) {
            hierarchyClass = classService.findByName(hierarchy.getHierarchyClass().getName());
            if (hierarchyClass == null) {
                hierarchyClass = classService.save(hierarchy.getHierarchyClass());
                raiseException = true;
            }
        }
        // process the order data
        HierarchyOrder hierarchyOrder = null;
        if (hierarchy.getOrder() != null) {
            hierarchyOrder = orderService.findByName(hierarchy.getOrder().getName());
            if (hierarchyOrder == null) {
                hierarchyOrder = orderService.save(hierarchy.getOrder());
                raiseException = true;
            }
        }
        // process the family data
        Family family = null;
        if (hierarchy.getFamily() != null) {
            family = familyService.findByName(hierarchy.getFamily().getName());
            if (family == null) {
                family = familyService.save(hierarchy.getFamily());
                raiseException = true;
            }
        }
        // process the genus data
        Genus genus = validateGenus(hierarchy.getGenus(), species);
        // initialize the hierarchy values
        hierarchy.init(kingdom, phylum, hierarchyClass, hierarchyOrder, family, genus, null, null);
        return hierarchy;
    }

    /**
     * NOTE: Processing Genus once that does not exists on Species data
     * @param genus
     * @param species
     * @return
     */
    private Genus validateGenus(Genus genus, Species species) {
        // process the genus data
        Genus result = null;
        if (genus != null) {
            genus = genusService.findByName(genus.getName());
            if (genus == null) {
                genus = genusService.save(genus);
                //raiseException = true;
            }
        } else {
            if (species.getScientificName() != null) {
                JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.SPECIES_PLUS.name());
                List<Genus> genusList = (List<Genus>) runtime.getVariables().get("genus");
                if (genusList != null) {
                    for (Genus g : genusList) {
                        if (species.getScientificName().contains(g.getName())) {
                            genus = genusService.save(g);
                            //raiseException = true;
                            break;
                        }
                    }
                }
            }
        }
        return genus;
    }

}