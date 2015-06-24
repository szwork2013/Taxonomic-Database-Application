package com.unep.wcmc.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.ExtinctionRiskConfigurationRepository;
import com.unep.wcmc.repository.SpeciesRepository;

@Service
public class ExtinctionRiskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtinctionRiskService.class);
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ExtinctionRiskConfigurationRepository configurationRepo;

    @Autowired
    private SpeciesRepository specieRepository;

    /**
     * Reprocess the extinction risk calculation for all species every day at midnight
     */
    @Scheduled(cron = "0 1 0 * * *")
    public void processExtinctionRisksForAllSpecies() {
        for (Species species : specieRepository.findAll()) {
            processExtinctionRiskCalculation(species);
        }
    }

    /**
     * Process the Extinction Risks Algorithm calculation
     * @param species
     */
    public void processExtinctionRiskCalculation(Species species) {
        final KieSession session = kieContainer.newKieSession("RulesSession");
        try {
            session.setGlobal("species", species);
            session.setGlobal("configuration", Lists.newArrayList(configurationRepo.findAll()));
            // set the business rules facts
            session.insert(species.getDistributionArea());
            session.insert(species.getNaturalHistory());
            session.insert(species.getNaturalHistory().getPopulationDynamics());
            session.insert(species.getNaturalHistory().getPopulationDynamics().getPopulationTrend());
            session.insert(species.getTaxonomy());
            session.insert(species.getThreat());
            // firing all the rules
            session.fireAllRules();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        } finally {
            session.destroy();
        }
    }
}
