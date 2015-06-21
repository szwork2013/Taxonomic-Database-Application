package com.unep.wcmc.test.rules;

import com.unep.wcmc.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ExtinctionRiskTest {

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

    /**
     * If this passes, then the {@link KieSession} was initialised and injected
     * into the Spring components.
     */
    @Test
    public void shouldConfigureDroolsComponents() {
        Assert.assertNotNull(kieSession);
    }

    @Test
    public void testCriticallyEndangered_CR() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);

        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setExtendOccurrence(99d);
        distributionArea.setOccupancyArea(9d);
        kieSession.insert(distributionArea);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setMatureIndividualsNumber(249l);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(specie.getExtinctionRiskCategory(),
                ExtinctionRiskCategory.CRITICALLY_ENDANGERED);
    }

    @Test
    public void testExtinct_EX() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);

        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(true);
        kieSession.insert(extinctionRisk);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setCaptiveBreedingProgram(false);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(specie.getExtinctionRiskCategory(),
                ExtinctionRiskCategory.EXTINCT);
    }

    @Test
    public void testExtincInTheWild_EW() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);

        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(true);
        kieSession.insert(extinctionRisk);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setCaptiveBreedingProgram(true);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(specie.getExtinctionRiskCategory(),
                ExtinctionRiskCategory.EXTINCT_IN_THE_WILD);
    }

    @Test
    public void testRegionallyExtinct_RE() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);

        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(false);
        kieSession.insert(extinctionRisk);

        PopulationDynamics populationDynamics = new PopulationDynamics();
        populationDynamics.setCaptiveBreedingProgram(false);
        kieSession.insert(populationDynamics);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(specie.getExtinctionRiskCategory(),
                ExtinctionRiskCategory.REGIONALLY_EXTINCT);
    }

}
