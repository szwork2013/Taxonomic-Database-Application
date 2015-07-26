package com.unep.wcmc.integration.flora;

import com.unep.wcmc.model.Species;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FloraWriter implements ItemWriter<Species> {

    @Override
    public void write(List<? extends Species> items) throws Exception {
        // TODO
    }

}