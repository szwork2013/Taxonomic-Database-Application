package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.integration.JobRuntime;
import com.unep.wcmc.model.*;
import com.unep.wcmc.service.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.unep.wcmc.integration.JobRuntime.JobVariable.EXCEPTIONS_COUNT;
import static com.unep.wcmc.integration.JobRuntime.JobVariable.INSERTS_COUNT;
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
            Taxonomy taxonomy = species.getTaxonomy();
            Hierarchy hierarchy = writeTaxonomyHierarchy(taxonomy.getHierarchy(), species);
            taxonomy.setHierarchy(hierarchy);
            taxonomy = writeTaxonomy(taxonomy);
            species.setTaxonomy(taxonomy);
            writeSpecies(species);
        }
    }

    private Hierarchy writeTaxonomyHierarchy(Hierarchy hierarchy, Species species) {
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
        Genus genus = writeGenus(hierarchy.getGenus(), species);
        // initialize the hierarchy values
        hierarchy.init(kingdom, phylum, hierarchyClass, hierarchyOrder, family, genus, species.getScientificName(), null);
        return hierarchy;
    }

    private Genus writeGenus(Genus genus, Species species) {
        // process the genus data
        Genus result = null;
        if (genus != null) {
            genus = genusService.findByName(genus.getName());
            if (genus == null) {
                genus = genusService.save(genus);
                raiseException = true;
            }
        } else {
            if (species.getScientificName() != null) {
                JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.SPECIES_PLUS.name());
                List<Genus> genusList = (List<Genus>) runtime.getVariables().get("genus");
                if (genusList != null) {
                    for (Genus g : genusList) {
                        if (species.getScientificName().contains(g.getName())) {
                            genus = genusService.save(g);
                            raiseException = true;
                            break;
                        }
                    }
                }
            }
        }
        return genus;
    }

    private Taxonomy writeTaxonomy(Taxonomy taxonomy) {
        // validate if the taxonomy data exists on the database
        List<Taxonomy> taxonomyList = taxonomyService.findByHierarchy(taxonomy);
        if (taxonomyList == null || taxonomyList.isEmpty()) {
            taxonomy.setEnabled(false);
            taxonomyService.save(taxonomy);
        } else {
            taxonomy = taxonomyList.get(0);
        }
        return taxonomy;
    }

    private Species writeSpecies(Species species) {
        // NOTE: only processing Fauna species at this time
        species.setType(Species.SpeciesType.FAUNA);

        JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.SPECIES_PLUS.name());
        // validating if taxonomy is broken then an exception should be raised
        if (raiseException) {
            EXCEPTIONS_COUNT.increment(runtime);
            species.setEnabled(false);
            species = speciesService.save(species);
            speciesService.raiseSpeciesException(species, species,
                    ExceptionOccurrence.Severity.MAJOR,
                    IntegrationSource.Source.SPECIES_PLUS);
            return species;
        }
        // verifying if the species already exists and updates if true
        Species existing = speciesService.findByScientificName(species.getScientificName());
        if (existing != null) {
            UPDATES_COUNT.increment(runtime);
            existing.setCommonName(species.getCommonName());
            existing.setScientificName(species.getScientificName());
            existing.setTaxonomy(species.getTaxonomy());
            existing.setEnabled(true);
            return speciesService.save(existing);

        } else {
            // validating if there are similar species in the database
            List<Species> similaries = speciesService.findByScientificNameSimilaries(species.getScientificName());
            if (similaries != null && !similaries.isEmpty()) {
                EXCEPTIONS_COUNT.increment(runtime);
                species.setType(similaries.get(0).getType());
                species.setEnabled(false);
                species = speciesService.save(species);
                speciesService.raiseSpeciesException(similaries.get(0), species,
                        ExceptionOccurrence.Severity.MAJOR, IntegrationSource.Source.SPECIES_PLUS);
                return species;
            } else {
                species.setEnabled(false);
                species = speciesService.save(species);
                speciesService.raiseSpeciesException(species, species,
                        ExceptionOccurrence.Severity.MAJOR, IntegrationSource.Source.SPECIES_PLUS);
                return species;
            }
        }
    }

}