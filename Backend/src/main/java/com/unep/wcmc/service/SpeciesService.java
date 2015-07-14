package com.unep.wcmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.filter.SpeciesFilter;
import com.unep.wcmc.model.filter.SpeciesSpecification;
import com.unep.wcmc.repository.SpeciesRepository;

@Service
public final class SpeciesService extends AbstractService<Species, SpeciesRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;

    @Override
    public Species save(Species specie) {
        extinctionRiskService.processExtinctionRiskCalculation(specie);
        return super.save(specie);
    }

    public Page<Species> findAll(SpeciesFilter filter, Pageable pageable) {
		return repo.findAll(SpeciesSpecification.filter(filter), pageable);
    }
}