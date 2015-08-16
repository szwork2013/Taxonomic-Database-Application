package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.PopulationTrend;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.service.ExtinctionRiskService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NearThreatenedTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testNearThreatened_EN_1() {
        Species species = new Species();

        PopulationTrend trend = new PopulationTrend();

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_2() {
        Species specie = new Species();

        PopulationTrend trend = new PopulationTrend();
        trend.setDeclineReversibleAndCeased(false);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_3() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setExtendOccurrence(25000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_4() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setExtendOccurrence(31000d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);

        Assert.assertNotNull(specie);
        Assert.assertNotEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_5() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setOccupancyArea(2500d);
        //distributionArea.setTrendExtendOccurence(TrendOccurence.DECLINING);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testNearThreatened_EN_6() {
        Species specie = new Species();

        DistributionArea distributionArea = new DistributionArea();
        //distributionArea.setOccupancyArea(3100d);
        //distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);

        Assert.assertNotNull(specie);
        Assert.assertNotEquals(ExtinctionRiskCategory.NEAR_THREATENED,
                specie.getExtinctionRiskCategory());
    }

}
