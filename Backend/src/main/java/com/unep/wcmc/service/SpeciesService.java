package com.unep.wcmc.service;

import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public final class SpeciesService extends AbstractService<Species, SpeciesRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public Species findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }

    public Species findOrSave(Species species) {
        if (species != null) {
            Species existing = repo.findByScientificName(species.getScientificName());
            if (existing == null) {
                if (species.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(species.getIntegrationSource().getSource());
                    species.setIntegrationSource(integration);
                }
                species = repo.save(species);
            } else {
                species = existing;
            }
        }
        return species;
    }

    @Override
    public Species save(Species specie) {
        extinctionRiskService.processExtinctionRiskCalculation(specie);
        return super.save(specie);
    }

    public Page<Species> findByCommonNameStartingWith(String query, Pageable pageable) {
        return repo.findByCommonNameStartingWith(query, pageable);
    }
}