package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.model.*;
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
        // gets the taxonomy data
        Taxonomy taxonomy = species.getTaxonomy();
        // gets the hierarchy data
        Hierarchy hierarchy = taxonomy.getHierarchy();
        // validate if the hierarcy data exists on the database
        Kingdom kingdom = null;
        if (hierarchy.getKingdom() != null) {
            kingdom = kingdomService.findOrSave(hierarchy.getKingdom());
        }
        Phylum phylum = null;
        if (hierarchy.getPhylum() != null) {
            phylum = phylumService.findOrSave(hierarchy.getPhylum());
        }
        HierarchyClass hierarchyClass = null;
        if (hierarchy.getHierarchyClass() != null) {
            hierarchyClass = hierarchyClassService.findOrSave(hierarchy.getHierarchyClass());
        }
        HierarchyOrder hierarchyOrder = null;
        if (hierarchy.getOrder() != null) {
            hierarchyOrder = hierarchyOrderService.findOrSave(hierarchy.getOrder());
        }
        Family family = null;
        if (hierarchy.getFamily() != null) {
            family = familyService.findOrSave(hierarchy.getFamily());
        }
        Genus genus = null;
        if (hierarchy.getGenus() != null) {
            genus = genusService.findOrSave(hierarchy.getGenus());
        }
        hierarchy.init(kingdom, phylum, hierarchyClass, hierarchyOrder, family, genus, null, null);
        // validate if the taxonomy data exists on the database
        taxonomy = taxonomyService.findOrSave(taxonomy);
        species.setTaxonomy(taxonomy);
        // insert the species on the database
        speciesService.findOrSave(species);
    }

}