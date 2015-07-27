package com.unep.wcmc.integration.flora;

import com.unep.wcmc.model.Species;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FloraProcessor implements ItemProcessor<String[], Species> {

    @Override
    public Species process(String[] item) throws Exception {
        // TODO
        return null;
    }


}