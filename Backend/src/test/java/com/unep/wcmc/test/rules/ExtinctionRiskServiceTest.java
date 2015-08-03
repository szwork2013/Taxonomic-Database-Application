package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.*;
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
public class ExtinctionRiskServiceTest {

    private KieServices kieServices;
    private KieContainer kieContainer;
    private KieSession kieSession;

    @Autowired
    private ExtinctionRiskService service;

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
    public void testEndangered_EN() {
        Species specie = new Species();
        specie.setCommonName("macaco-prego-galego");
        specie.setScientificName("Sapajus flavius");

        DistributionArea distributionArea = new DistributionArea();
        // Extent of Occurrence (km2) - EOO
        distributionArea.setExtendOccurrence(23000d);
        // Occurs in Brasil
        distributionArea.setOcurrsBrazil(true);
        // Native in Brasil
        distributionArea.setNativeBrazil(true);
        // Endemic form Brasil
        distributionArea.setEndemicFromBrazil(true);
        // Area of occupancy (km2) - AOO
        distributionArea.setOccupancyArea(150d);
        // Trend in area of occupancy
        distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        specie.setDistributionArea(distributionArea);

        PopulationTrend trend = new PopulationTrend();
        // In case of past reduction, is the cause reversible and has ceased?
        trend.setDeclineReversibleAndCeased(false);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        // Number of mature individuals
        populationDynamics.setMatureIndividualsNumber(500l);
        // Number of Subpopulations
        populationDynamics.setMatureIndividualsSubpopulationMaxNumber(250l);
        // Population severely fragmented
        populationDynamics.setPopulationSeverelyFragmented(true);
        populationDynamics.setPopulationTrend(trend);
        NaturalHistory naturalHistory = new NaturalHistory();
        naturalHistory.setPopulationDynamics(populationDynamics);
        specie.setNaturalHistory(naturalHistory);

        Threat threat = new Threat();
        specie.setThreat(threat);

        service.processExtinctionRiskCalculation(specie);

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testProcessExtinctionRisksForAllSpecies() {
        service.processExtinctionRisksForAllSpecies(kieSession);
        Assert.assertTrue(true);
    }

}
