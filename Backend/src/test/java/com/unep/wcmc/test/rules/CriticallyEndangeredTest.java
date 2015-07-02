package com.unep.wcmc.test.rules;

import com.google.common.collect.Lists;
import com.unep.wcmc.Application;
import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.ExtinctionRiskConfigurationRepository;
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
public class CriticallyEndangeredTest {

    private KieServices kieServices;
    private KieContainer kieContainer;
    private KieSession kieSession;

    @Autowired
    private ExtinctionRiskConfigurationRepository repo;

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
    public void testCriticallyEndangered_EN_1() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        // % population decline in 10 years or 3 generations and period
        trend.setPercPopulationDecline(90d);
        // In case of past reduction, is the cause reversible and has ceased?
        kieSession.insert(trend);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_2() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        // % population decline in 10 years or 3 generations and period
        trend.setPercPopulationDecline(80d);
        trend.setDeclineReversibleAndCeased(false);
        // In case of past reduction, is the cause reversible and has ceased?
        kieSession.insert(trend);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_3() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        distributionArea.setExtendOccurrence(100d);
        distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_4() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        distributionArea.setExtendOccurrence(100d);
        distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);
        kieSession.insert(habitat);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_5() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        distributionArea.setExtendOccurrence(100d);
        distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);
        kieSession.insert(habitat);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

}
