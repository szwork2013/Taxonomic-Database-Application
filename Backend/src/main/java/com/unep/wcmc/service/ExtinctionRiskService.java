package com.unep.wcmc.service;

import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.Threat;
import com.unep.wcmc.repository.SpeciesRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ExtinctionRiskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtinctionRiskService.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private SpeciesRepository specieRepository;

    /**
     * Reprocess the extinction risk calculation for all species every day at midnight
     */
    @Scheduled(cron = "0 1 0 * * *")
    public void processExtinctionRisksForAllSpecies() {
        for (Species species : specieRepository.findAll()) {
            processExtinctionRiskCalculation(species);
            specieRepository.save(species);
        }
    }

    /**
     * Reprocess the extinction risks calculation for all species
     * @param session
     */
    public void processExtinctionRisksForAllSpecies(KieSession session) {
        for (Species species : specieRepository.findAll()) {
            processExtinctionRiskCalculation(species, session);
            specieRepository.save(species);
        }
    }

    /**
     * Process the Extinction Risks Algorithm calculation
     * @param species
     */
    public void processExtinctionRiskCalculation(Species species) {
        final KieSession session = kieContainer.newKieSession("ExtinctionRisk");
        processExtinctionRiskCalculation(species, session);
    }

    /**
     * Process the Extinction Risks Algorithm calculation
     * @param species
     * @param session
     */
    public void processExtinctionRiskCalculation(Species species, KieSession session) {
        if (session != null) {
            try {
                // using the LEAST CONCERN as default
                species.setExtinctionRiskCategory(ExtinctionRiskCategory.LEAST_CONCERN);
                // global variables
                session.setGlobal("species", species);
                // set the business rules facts
                if (species != null) {
                    // set the Taxonomy facts
                    session.insert(species.getTaxonomy());
                    // set the Distribution Area facts
                    if (species.getDistributionArea() != null) {
                        session.insert(species.getDistributionArea());
                        session.insert(species.getDistributionArea().getExtentOccurrence());
                        session.insert(species.getDistributionArea().getAreaOccupancy());
                    }

                    // set the Natural History facts
                    if (species.getNaturalHistory() != null) {
                        session.insert(species.getNaturalHistory());
                        if (species.getNaturalHistory().getPopulationDynamics() != null) {
                            session.insert(species.getNaturalHistory().getPopulationDynamics());
                            session.insert(species.getNaturalHistory().getPopulationDynamics().getPopulationTrend());
                            session.insert(species.getNaturalHistory().getPopulationDynamics().getDensityData());
                        }
                    }
                    // set the Conservation facts
                    if (species.getConservation() != null) {
                        session.insert(species.getConservation());
                        session.insert(species.getConservation().getExtinctionRisk());
                    }
                    // set the Threat facts
                    for (Threat threat : species.getThreats()) {
                        session.insert(threat);
                    }
                }
                // firing all the rules
                session.fireAllRules();
            } catch (Exception e) {
                LOGGER.debug(e.getMessage());
            } finally {
                session.destroy();
            }
        }
    }
}
