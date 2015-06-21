package com.unep.wcmc.service;

import com.google.common.collect.Lists;
import com.unep.wcmc.model.Specie;
import com.unep.wcmc.repository.ExtinctionRiskConfigurationRepository;
import com.unep.wcmc.repository.SpecieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class SpecieService extends AbstractService<Specie, SpecieRepository> {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ExtinctionRiskConfigurationRepository configurationRepo;

    public Specie findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }

    @Override
    public Specie save(Specie specie) {
        processExtinctionRiskCalculation(specie);
        return super.save(specie);
    }

    /**
     * Process the Extinction Risks Algorithm calculation
     * @param specie
     */
    private void processExtinctionRiskCalculation(Specie specie) {
        KieSession session = kieContainer.newKieSession("RulesSession");
        session.setGlobal("specie", specie);
        session.setGlobal("configuration", Lists.newArrayList(configurationRepo.findAll()));
        // set the business rules facts
        session.insert(specie.getDistributionArea());
        session.insert(specie.getNaturalHistory());
        session.insert(specie.getNaturalHistory().getPopulationDynamics());
        session.insert(specie.getNaturalHistory().getPopulationDynamics().getPopulationTrend());
        session.insert(specie.getTaxonomy());
        session.insert(specie.getThreat());
        // firing all the rules
        session.fireAllRules();
        session.destroy();
    }
}
