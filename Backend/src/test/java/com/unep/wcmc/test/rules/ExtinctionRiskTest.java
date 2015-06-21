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
public class ExtinctionRiskTest {

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

    /**
     * If this passes, then the {@link KieSession} was initialised and injected
     * into the Spring components.
     */
    @Test
    public void shouldConfigureDroolsComponents() {
        Assert.assertNotNull(kieSession);
    }

    @Test
    public void testEndangered_EN() {
        Specie specie = new Specie();
        specie.setCommonName("macaco-prego-galego");
        specie.setScientificName("Sapajus flavius");
        kieSession.setGlobal("specie", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setExtendOccurrence(23000d);
        distributionArea.setOcurrsBrazil(true);
        distributionArea.setNativeBrazil(true);
        distributionArea.setEndemicFromBrazil(true);
        distributionArea.setOccupancyArea(150d);
        distributionArea.setTrendOccupancyArea(TrendOccurence.DECLINING);
        kieSession.insert(distributionArea);

        PopulationTrend trend = new PopulationTrend();
        trend.setPercPopulationDecline(50d);
        trend.setDeclineReversibleAndCeased(false);
        kieSession.insert(trend);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(500l);
        populationDynamics.setMatureIndividualsSubpopulationMaxNumber(250l);
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

    @Test
    public void testExtinct_EX() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(true);
        kieSession.insert(extinctionRisk);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(0l);
        populationDynamics.setCaptiveBreedingProgram(false);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.EXTINCT,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testExtinctInTheWild_EW() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(true);
        kieSession.insert(extinctionRisk);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(0l);
        populationDynamics.setCaptiveBreedingProgram(true);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.EXTINCT_IN_THE_WILD,
                specie.getExtinctionRiskCategory());
    }

    @Test
    public void testRegionallyExtinct_RE() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(false);
        kieSession.insert(extinctionRisk);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(0l);
        populationDynamics.setCaptiveBreedingProgram(false);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.REGIONALLY_EXTINCT,
                specie.getExtinctionRiskCategory());
    }

}