package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.KingdomRepository;
import com.unep.wcmc.service.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpeciesPlusWriter implements ItemWriter<List<Species>> {

    @Autowired
    private KingdomService kingdomService;

    @Autowired
    private PhylumService phylumService;

    @Autowired
    private HierarchyClassService hierarchyClassService;

    @Autowired
    private HierarchyOrderService hierarchyOrderService;

    @Autowired
    private FamilyService familyService;

    @Autowired
    private GenusService genusService;

    @Autowired
    private TaxonomyService taxonomyService;

    @Autowired
    private SpeciesService speciesService;

    @Override
    public void write(List<? extends List<Species>> items) throws Exception {
        for (List<Species> speciesList : items) {
            for (Species species : speciesList) {
                writeSpecies(species);
            }
        }
    }

    public void writeSpecies(Species species) {
        Taxonomy taxonomy = species.getTaxonomy();

        Hierarchy hierarchy = taxonomy.getHierarchy();
        Kingdom kingdom = kingdomService.findOrSave(hierarchy.getKingdom().getName());
        Phylum phylum = phylumService.findOrSave(hierarchy.getPhylum().getName());
        HierarchyClass hierarchyClass = hierarchyClassService.findOrSave(hierarchy.getHierarchyClass().getName());
        HierarchyOrder hierarchyOrder = hierarchyOrderService.findOrSave(hierarchy.getOrder().getName());
        Family family = familyService.findOrSave(hierarchy.getFamily().getName());
        Genus genus = genusService.findOrSave(hierarchy.getGenus().getName());
        hierarchy.init(kingdom, phylum, hierarchyClass, hierarchyOrder, family, genus, null, null);

        taxonomy = taxonomyService.findOrSave(taxonomy);

        speciesService.save(species);
    }

}