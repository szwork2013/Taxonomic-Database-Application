package com.unep.wcmc.integration.fauna;

import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.integration.JobRuntime;
import com.unep.wcmc.model.Hierarchy;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.service.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.unep.wcmc.integration.JobRuntime.JobVariable.INSERTS_COUNT;
import static com.unep.wcmc.integration.JobRuntime.JobVariable.UPDATES_COUNT;

@Component
public class FaunaWriter implements ItemWriter<Species> {

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

    @Override
    public void write(List<? extends Species> items) throws Exception {
        for (Species species : items) {
            if (species.getTaxonomy() != null) {
                Taxonomy taxonomy = writeTaxonomy(species.getTaxonomy());
                species.setTaxonomy(taxonomy);
                writeSpecies(species);
            }
        }
    }

    private Taxonomy writeTaxonomy(Taxonomy taxonomy) {
        Hierarchy hierarchy = taxonomy.getHierarchy();

        hierarchy.setKingdom(kingdomService.findOrSave(hierarchy.getKingdom()));
        hierarchy.setPhylum(phylumService.findOrSave(hierarchy.getPhylum()));
        hierarchy.setHierarchyClass(classService.findOrSave(hierarchy.getHierarchyClass()));
        hierarchy.setOrder(orderService.findOrSave(hierarchy.getOrder()));
        hierarchy.setFamily(familyService.findOrSave(hierarchy.getFamily()));
        hierarchy.setGenus(genusService.findOrSave(hierarchy.getGenus()));

        taxonomy.setHierarchy(hierarchy);
        return taxonomyService.findOrSave(taxonomy);
    }

    private Species writeSpecies(Species species) {
        JobRuntime runtime = jobRunner.getJobRuntime(IntegrationSource.Source.FAUNA.name());

        List<Species> existingList = speciesService.findByScientificName(species.getScientificName());
        if (existingList != null && !existingList.isEmpty()) {
            Species existing = existingList.get(0);
            UPDATES_COUNT.increment(runtime);
            existing.setName(species.getName());
            existing.setScientificName(species.getScientificName());
            existing.setTaxonomy(species.getTaxonomy());
            existing.setEnabled(true);
            species = existing;
        } else {
//            List<Species> similaries = speciesService.findByScientificNameSimilaries(species.getScientificName());
//            if (similaries != null && !similaries.isEmpty()) {
//                EXCEPTIONS_COUNT.increment(runtime);
//                species.setEnabled(false);
//                species = speciesService.save(species);
//                speciesService.raiseSpeciesException(similaries.get(0), species, IntegrationSource.Source.FLORA);
//                return species;
//            } else {
                INSERTS_COUNT.increment(runtime);
                UPDATES_COUNT.increment(runtime);
                species.setEnabled(true);
//            }
        }
        return speciesService.save(species);

    }

}