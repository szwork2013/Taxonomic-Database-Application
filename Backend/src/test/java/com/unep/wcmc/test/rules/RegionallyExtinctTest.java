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
public class RegionallyExtinctTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testRegionallyExtinct_RE_equals() {
        Species species = new Species();

        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setEndemicFromBrazil(false);
        species.setDistributionArea(distributionArea);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(0l);
        populationDynamics.setCaptiveBreedingProgram(false);
        NaturalHistory naturalHistory = new NaturalHistory(populationDynamics);
        species.setNaturalHistory(naturalHistory);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.REGIONALLY_EXTINCT,
                species.getExtinctionRiskCategory());
    }

    @Test
    public void testRegionallyExtinct_RE_notEquals() {
        Species species = new Species();

        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setEndemicFromBrazil(true);
        species.setDistributionArea(distributionArea);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(0l);
        populationDynamics.setCaptiveBreedingProgram(true);
        NaturalHistory naturalHistory = new NaturalHistory(populationDynamics);
        species.setNaturalHistory(naturalHistory);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertNotEquals(ExtinctionRiskCategory.REGIONALLY_EXTINCT,
                species.getExtinctionRiskCategory());
    }

}
