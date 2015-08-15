package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.service.ExtinctionRiskService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DataDeficientTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testDataDeficient_DD_1() {
        Species species = new Species();
        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setLimitationsForAssessment(true);
        species.setTaxonomy(taxonomy);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.DATA_DEFICIENT,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testDataDeficient_DD_2() {
        Species species = new Species();
        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setOnlyFromFewLocalities(true);
        species.setDistributionArea(distributionArea);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.DATA_DEFICIENT,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testDataDeficient_DD_3() {
        Species species = new Species();
        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setOnlyFromFewLocalities(true);
        distributionArea.setRegionIsWellSampled(false);
        species.setDistributionArea(distributionArea);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.DATA_DEFICIENT,
                species.getExtinctionRiskCategory());
    }

}
