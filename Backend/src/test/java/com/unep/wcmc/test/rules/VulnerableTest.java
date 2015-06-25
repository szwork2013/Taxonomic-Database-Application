package com.unep.wcmc.test.rules;

import com.google.common.collect.Lists;
import com.unep.wcmc.Application;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.PopulationTrend;
import com.unep.wcmc.model.Species;
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
public class VulnerableTest {

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
    public void testVulnerable_VU_A() {
        Species specie = new Species();
        specie.setScientificName("Hypsiboas curupi Garcia, Faivovichi & Haddad, 2007");
        kieSession.setGlobal("species", specie);
        kieSession.setGlobal("configuration", Lists.newArrayList(repo.findAll()));

        PopulationTrend trend = new PopulationTrend();
        trend.setDeclineReversibleAndCeased(false);
        trend.setPercPopulationDecline(55d);
        kieSession.insert(trend);

        kieSession.fireAllRules();

        Assert.assertNotNull(specie);
        Assert.assertEquals(ExtinctionRiskCategory.VUNERABLE,
                specie.getExtinctionRiskCategory());
    }

}
