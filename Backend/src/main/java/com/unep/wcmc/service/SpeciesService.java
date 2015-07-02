package com.unep.wcmc.service;

import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class SpeciesService extends AbstractService<Species, SpeciesRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;


    public Species findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }

    @Override
    public Species save(Species specie) {
        extinctionRiskService.processExtinctionRiskCalculation(specie);
        return super.save(specie);
    }

    public List<Species> findByScientificName(String query, Pageable pageable) {

        return repo.findByScientificNameStartingWith(query, pageable);
    }
}