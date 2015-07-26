package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.service.SpeciesPlusService;
import com.unep.wcmc.service.SpeciesPlusService.SpeciesPlusRank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@SuppressWarnings("all")
public class SpeciesPlusReader implements ItemReader<Map<String, Object>> {

    protected static final Log logger = LogFactory.getLog(SpeciesPlusReader.class);

    @Autowired
    private SpeciesPlusService speciesPlusService;

    private boolean firstExecution = true;
    private List<Map<String, Object>> taxonConcepts;


    public Map<String, Object> read() throws Exception {

        if (firstExecution && speciesPlusService.hasNextTaxon()) {
            taxonConcepts = readTaxonConcepts();
            firstExecution = false;
        }

        Map<String, Object> species = readSpecies();
        if (species != null) {
            return species;
        }

        if (speciesPlusService.hasNextTaxon()) {
            taxonConcepts = readTaxonConcepts();
            species = readSpecies();
            if (species != null) {
                return species;
            }
        }

        return null;
    }

    private List<Map<String, Object>> readTaxonConcepts() {
        Map<String, Object> taxonPage = speciesPlusService.nextTaxonPage();
        return (List<Map<String, Object>>) taxonPage.get("taxon_concepts");
    }

    private Map<String, Object> readSpecies() {
        while (!taxonConcepts.isEmpty()) {
            Map<String, Object> taxon = taxonConcepts.remove(0);
            SpeciesPlusRank rank = SpeciesPlusRank.valueOf(String.valueOf(taxon.get("rank")));
            if (rank == SpeciesPlusRank.SPECIES || rank == SpeciesPlusRank.GENUS) {
                return taxon;
            }
        }
        return null;
    }


}