package com.unep.wcmc.service;

import com.google.common.collect.Lists;
import com.unep.wcmc.model.Specie;
import com.unep.wcmc.repository.ExtinctionRiskConfigurationRepository;
import com.unep.wcmc.repository.SpecieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class ExtinctionRiskService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ExtinctionRiskConfigurationRepository configurationRepo;

    @Autowired
    private SpecieRepository specieRepository;

    /**
     * Reprocess the extinction risk calculation for all species every day at midnight
     */
    @Scheduled(cron = "0 1 0 * * *")
    public void processExtinctionRisksForAllSpecies() {
        Iterator<Specie> species = specieRepository.findAll().iterator();
        while (species.hasNext()) {
            processExtinctionRiskCalculation(species.next());
        }
    }

    /**
     * Process the Extinction Risks Algorithm calculation
     * @param specie
     */
    public void processExtinctionRiskCalculation(Specie specie) {
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
