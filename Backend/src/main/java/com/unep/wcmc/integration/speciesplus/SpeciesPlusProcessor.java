package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.model.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@SuppressWarnings("all")
public class SpeciesPlusProcessor implements ItemProcessor<Map<String, Object>, List<Species>> {

    public enum SpeciesPlusRank { KINGDOM, PHYLUM, CLASS, ORDER, FAMILY, SUBFAMILY, GENUS, SPECIES, SUBSPECIES, VARIETY }

    @Override
    public List<Species> process(Map<String, Object> item) throws Exception {
        List<Species> speciesList = new ArrayList<>();

        List<Map<String, Object>> taxonConcepts = (List<Map<String, Object>>)
                item.get("taxon_concepts");

        for (Map<String, Object> taxon : taxonConcepts) {
            SpeciesPlusRank rank = SpeciesPlusRank.valueOf(String.valueOf(taxon.get("rank")));
            BaseEntity entity = null;
            switch (rank) {
                case SPECIES:
                    Species species = processSpecies(taxon);
                    speciesList.add(species);
                    break;
            }
        }

        return speciesList;
    }


    public Species processSpecies(Map<String, Object> taxon) {
        Map<String, Object> higherTaxa = (Map<String, Object>)
                taxon.get("higher_taxa");
        Kingdom kingdom = new Kingdom(String.valueOf(higherTaxa.get("kingdom")));
        Phylum phylum = new Phylum(String.valueOf(higherTaxa.get("phylum")));
        HierarchyClass hierarchyClass = new HierarchyClass(String.valueOf(higherTaxa.get("class")));
        HierarchyOrder hierarchyOrder = new HierarchyOrder(String.valueOf(higherTaxa.get("order")));
        Family family = new Family(String.valueOf(higherTaxa.get("family")));
        Genus genus = new Genus(String.valueOf(higherTaxa.get("genus")));
        Hierarchy hierarchy = new Hierarchy(kingdom, phylum, hierarchyClass, hierarchyOrder,
                family, genus, null, null);
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setHierarchy(hierarchy);
        Species species = new Species();
        species.setTaxonomy(taxonomy);
        species.setScientificName(String.valueOf(taxon.get("full_name")));
        List<Map<String,Object>> commonNames = (List<Map<String,Object>>) taxon.get("common_names");
        if (commonNames != null && !commonNames.isEmpty()) {
            species.setCommonName(String.valueOf(commonNames.get(0).get("name")));
        }
        return species;
    }

}
