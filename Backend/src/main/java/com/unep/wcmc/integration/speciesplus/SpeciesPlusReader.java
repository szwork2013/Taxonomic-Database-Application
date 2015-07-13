package com.unep.wcmc.integration.speciesplus;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpeciesPlusReader implements ItemReader<Map<String, Object>> {

    @Autowired
    private SpeciesPlusService speciesPlusService;

    public Map<String, Object> read() throws Exception {
        if (speciesPlusService.hasNextTaxon()) {
            return speciesPlusService.nextTaxonPage();
        }
        return null;
    }

}