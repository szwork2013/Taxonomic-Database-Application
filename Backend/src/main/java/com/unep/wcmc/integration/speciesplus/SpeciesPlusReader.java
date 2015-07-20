package com.unep.wcmc.integration.speciesplus;

import com.unep.wcmc.service.SpeciesPlusService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpeciesPlusReader implements ItemReader<Map<String, Object>> {

    protected static final Log logger = LogFactory.getLog(SpeciesPlusReader.class);

    @Autowired
    private SpeciesPlusService speciesPlusService;

    public Map<String, Object> read() throws Exception {
        if (speciesPlusService.hasNextTaxon()) {
            return speciesPlusService.nextTaxonPage();
        }
        return null;
    }

}