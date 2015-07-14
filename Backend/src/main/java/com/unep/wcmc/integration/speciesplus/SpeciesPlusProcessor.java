package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.unep.wcmc.model.IntegrationSource.Source.SPECIES_PLUS;

@Component
@SuppressWarnings("all")
public class SpeciesPlusProcessor implements ItemProcessor<Map<String, Object>, List<Species>> {

    protected static final Log logger = LogFactory.getLog(SpeciesPlusProcessor.class);

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
                    if (species != null) {
                        speciesList.add(species);
                    }
                    break;
            }
        }

        return speciesList;
    }


    public Species processSpecies(Map<String, Object> taxon) {
        try {
            Map<String, Object> higherTaxa = (Map<String, Object>)
                    taxon.get("higher_taxa");
            if (higherTaxa != null) {
                // create the kingom, phylum, class, order, family, genus, hierarchy data
                Kingdom kingdom = String.valueOf(higherTaxa.get("kingdom")).equalsIgnoreCase("null") ? null :
                        new Kingdom(String.valueOf(higherTaxa.get("kingdom")), new IntegrationSource(SPECIES_PLUS));
                Phylum phylum = String.valueOf(higherTaxa.get("phylum")).equalsIgnoreCase("null") ? null :
                        new Phylum(String.valueOf(higherTaxa.get("phylum")), new IntegrationSource(SPECIES_PLUS));
                HierarchyClass hierarchyClass = String.valueOf(higherTaxa.get("class")).equalsIgnoreCase("null") ? null :
                        new HierarchyClass(String.valueOf(higherTaxa.get("class")), new IntegrationSource(SPECIES_PLUS));
                HierarchyOrder hierarchyOrder = String.valueOf(higherTaxa.get("order")).equalsIgnoreCase("null") ? null :
                        new HierarchyOrder(String.valueOf(higherTaxa.get("order")), new IntegrationSource(SPECIES_PLUS));
                Family family = String.valueOf(higherTaxa.get("family")).equalsIgnoreCase("null") ? null :
                        new Family(String.valueOf(higherTaxa.get("family")), new IntegrationSource(SPECIES_PLUS));
                Genus genus = String.valueOf(higherTaxa.get("genus")).equalsIgnoreCase("null") ? null :
                        new Genus(String.valueOf(higherTaxa.get("genus")), new IntegrationSource(SPECIES_PLUS));
                Hierarchy hierarchy = new Hierarchy(kingdom, phylum, hierarchyClass, hierarchyOrder,
                        family, genus, null, null);
                // create the taxonomy data
                Taxonomy taxonomy = new Taxonomy();
                taxonomy.setHierarchy(hierarchy);
                taxonomy.setIntegrationSource(new IntegrationSource(SPECIES_PLUS));
                // create the species data
                Species species = new Species();
                species.setTaxonomy(taxonomy);
                species.setIntegrationSource(new IntegrationSource(SPECIES_PLUS));
                species.setScientificName(String.valueOf(taxon.get("full_name")));
                List<Map<String, Object>> commonNames = (List<Map<String, Object>>) taxon.get("common_names");
                if (commonNames != null && !commonNames.isEmpty()) {
                    species.setCommonName(String.valueOf(commonNames.get(0).get("name")));
                }
                return species;
            }
            return null;
        } catch (Exception ex) {
            logger.error("Error processing Species+ API data.", ex);
            throw new RuntimeException(ex);
        }
    }

}
