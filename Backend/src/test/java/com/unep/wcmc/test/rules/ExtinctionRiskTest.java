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
    public void testEndangered_EN() {
        Specie specie = new Specie();
        specie.setCommonName("macaco-prego-galego");
        specie.setScientificName("Sapajus flavius");
        kieSession.setGlobal("specie", specie);

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
    public void testExtincInTheWild_EW() {
        Specie specie = new Specie();
        kieSession.setGlobal("specie", specie);

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
