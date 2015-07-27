package com.unep.wcmc.integration.flora;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component
public class FloraReader implements ItemReader<String[]> {

    public String[] read() throws Exception {
        // TODO
        return null;
    }

}