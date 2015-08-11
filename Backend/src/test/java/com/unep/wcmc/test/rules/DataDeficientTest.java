package com.unep.wcmc.test.rules;

import com.google.common.collect.Lists;
import com.unep.wcmc.Application;
import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.Taxonomy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DataDeficientTest {

    private KieServices kieServices;
    private KieContainer kieContainer;
    private KieSession kieSession;

    @Before
    public void initialize() {
        if (kieSession != null) {
            kieSession.dispose();
        }
        this.kieServices = KieServices.Factory.get();
        this.kieContainer = kieServices.getKieClasspathContainer();
        this.kieSession = kieContainer.newKieSession("RulesSession");
    }

    @Test
    public void testDataDeficient_EN_1() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        Taxonomy taxonomy = new Taxonomy();
        taxonomy.setLimitationsForAssessment(true);
        kieSession.insert(taxonomy);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.DATA_DEFICIENT,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testDataDeficient_EN_2() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setOnlyFromFewLocalities(true);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.DATA_DEFICIENT,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testDataDeficient_EN_3() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setOnlyFromFewLocalities(true);
        distributionArea.setRegionIsWellSampled(false);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.DATA_DEFICIENT,
                specie.getExtinctionRiskCategory());
    }

}
