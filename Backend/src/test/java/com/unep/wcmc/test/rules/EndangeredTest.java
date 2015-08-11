package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.*;
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
public class EndangeredTest {

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
    public void testEndangered_EN_1() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        // In case of past reduction, is the cause reversible and has ceased?
        kieSession.insert(trend);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testEndangered_EN_2() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        trend.setDeclineReversibleAndCeased(false);
        // In case of past reduction, is the cause reversible and has ceased?
        kieSession.insert(trend);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testEndangered_EN_3() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        //distributionArea.setExtendOccurrence(5000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testEndangered_EN_4() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        //distributionArea.setExtendOccurrence(5000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);
        kieSession.insert(habitat);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testEndangered_EN_5() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        //distributionArea.setExtendOccurrence(5000d);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);
        kieSession.insert(habitat);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

}