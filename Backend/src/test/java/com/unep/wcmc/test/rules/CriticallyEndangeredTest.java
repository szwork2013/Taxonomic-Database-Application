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
public class CriticallyEndangeredTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testCriticallyEndangered_EN_1() {
        Species species = new Species();

        DistributionArea distributionArea = new DistributionArea();
        ExtentOccurrence extentOccurrence = new ExtentOccurrence();
        extentOccurrence.setEoo(99d);
        extentOccurrence.setTrend(TrendOccurence.DECLINING);
        distributionArea.setExtentOccurrence(extentOccurrence);
        species.setDistributionArea(distributionArea);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setPopulationSeverelyFragmented(true);
        NaturalHistory naturalHistory = new NaturalHistory(populationDynamics);
        species.setNaturalHistory(naturalHistory);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_2() {
        Species species = new Species();

        PopulationDynamics populationDynamics = new PopulationDynamics();
        PopulationReduction reductionWithCausesCeased = new PopulationReduction();
        reductionWithCausesCeased.setReduction(true);
        reductionWithCausesCeased.setPercentage(91);
        populationDynamics.setReductionWithCausesCeased(reductionWithCausesCeased);
        PopulationTrend populationTrend = new PopulationTrend();
        populationTrend.setPopulationDeclinedBasedOn(PopulationDeclinedBasedOn.DIRECT_OBSERVATION);
        populationDynamics.setPopulationTrend(populationTrend);
        NaturalHistory naturalHistory = new NaturalHistory(populationDynamics);
        species.setNaturalHistory(naturalHistory);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_3() {
        Species species = new Species();

        DistributionArea distributionArea = new DistributionArea();
        ExtentOccurrence extentOccurrence = new ExtentOccurrence();
        extentOccurrence.setEoo(100d);
        extentOccurrence.setTrend(TrendOccurence.DECLINING);
        distributionArea.setExtentOccurrence(extentOccurrence);
        AreaOccupancy areaOccupancy = new AreaOccupancy();
        areaOccupancy.setTrend(TrendOccurence.DECLINING);
        distributionArea.setAreaOccupancy(areaOccupancy);
        species.setDistributionArea(distributionArea);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_4() {
        Species species = new Species();

        DistributionArea distributionArea = new DistributionArea();
        ExtentOccurrence extentOccurrence = new ExtentOccurrence();
        extentOccurrence.setEoo(100d);
        extentOccurrence.setTrend(TrendOccurence.DECLINING);
        distributionArea.setExtentOccurrence(extentOccurrence);
        species.setDistributionArea(distributionArea);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);
        NaturalHistory naturalHistory = new NaturalHistory();
        naturalHistory.setHabitat(habitat);
        species.setNaturalHistory(naturalHistory);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testCriticallyEndangered_EN_5() {
        Species species = new Species();

        DistributionArea distributionArea = new DistributionArea();
        ExtentOccurrence extentOccurrence = new ExtentOccurrence();
        extentOccurrence.setEoo(100d);
        extentOccurrence.setTrend(TrendOccurence.DECLINING);
        distributionArea.setExtentOccurrence(extentOccurrence);
        species.setDistributionArea(distributionArea);

        Habitat habitat = new Habitat();
        habitat.setContinuingDeclineInHabitatQuality(true);
        NaturalHistory naturalHistory = new NaturalHistory();
        naturalHistory.setHabitat(habitat);
        species.setNaturalHistory(naturalHistory);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.CRITICALLY_ENDANGERED,
                species.getExtinctionRiskCategory());
    }

}
