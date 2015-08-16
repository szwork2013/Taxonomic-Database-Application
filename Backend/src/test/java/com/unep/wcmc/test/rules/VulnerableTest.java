package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.*;
import com.unep.wcmc.service.ExtinctionRiskService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class VulnerableTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testVulnerable_EN_1() {
        Species species = new Species();

        PopulationTrend trend = new PopulationTrend();
        // In case of past reduction, is the cause reversible and has ceased?

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.VUNERABLE,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testVulnerable_EN_2() {
        Species specie = new Species();

        PopulationTrend trend = new PopulationTrend();
        trend.setDeclineReversibleAndCeased(false);
        // In case of past reduction, is the cause reversible and has ceased?

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.VUNERABLE,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testVulnerable_EN_3() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        //distributionArea.setExtendOccurrence(20000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.VUNERABLE,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testVulnerable_EN_4() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        //distributionArea.setExtendOccurrence(20000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.VUNERABLE,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testVulnerable_EN_5() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        //distributionArea.setExtendOccurrence(20000d);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.VUNERABLE,
                specie.getExtinctionRiskCategory());
    }

}
