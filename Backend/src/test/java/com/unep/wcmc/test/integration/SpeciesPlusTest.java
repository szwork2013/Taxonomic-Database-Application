package com.unep.wcmc.test.integration;

import com.unep.wcmc.Application;
import com.unep.wcmc.integration.speciesplus.SpeciesPlusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SpeciesPlusTest {

    @Autowired
    private SpeciesPlusService speciesPlusService;

    @Test
    public void testRequest() {
        speciesPlusService.nextTaxonPage();
    }

}
