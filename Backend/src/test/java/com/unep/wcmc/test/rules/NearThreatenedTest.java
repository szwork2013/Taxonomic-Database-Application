package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.PopulationTrend;
import com.unep.wcmc.model.Species;
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
public class NearThreatenedTest {

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
    public void testNearThreatened_EN_1() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        kieSession.insert(trend);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_2() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        trend.setDeclineReversibleAndCeased(false);
        kieSession.insert(trend);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_3() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setExtendOccurrence(25000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_4() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setExtendOccurrence(31000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertNotEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_5() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setOccupancyArea(2500d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_6() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        //kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setOccupancyArea(3100d);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);
        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertNotEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

}
