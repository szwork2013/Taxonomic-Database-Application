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
public class EndangeredTest {

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
    public void testEndangered_EN() {
        Species specie = new Species();
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

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
        kieSession.insert(distributionArea);

        PopulationTrend trend = new PopulationTrend();
        // % population decline in 10 years or 3 generations and period
        trend.setPercPopulationDecline(50d);
        // In case of past reduction, is the cause reversible and has ceased?
        trend.setDeclineReversibleAndCeased(false);
        kieSession.insert(trend);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        // Number of mature individuals
        populationDynamics.setMatureIndividualsNumber(500l);
        // Number of Subpopulations
        populationDynamics.setMatureIndividualsSubpopulationMaxNumber(250l);
        // Population severely fragmented
        populationDynamics.setPopulationSeverelyFragmented(true);

        populationDynamics.setPopulationTrend(trend);
        kieSession.insert(populationDynamics);

        Threat threat = new Threat();
        kieSession.insert(threat);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.ENDANGERED,
                specie.getExtinctionRiskCategory());
    }

}