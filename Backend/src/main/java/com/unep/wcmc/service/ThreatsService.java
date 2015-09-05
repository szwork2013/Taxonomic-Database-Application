package com.unep.wcmc.service;

import com.unep.wcmc.model.Threat;
import com.unep.wcmc.repository.ThreatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ThreatsService extends AbstractService<Threat, ThreatsRepository> {

    @Autowired
    private SpeciesService speciesService;

    @Override
    public Threat save(Threat entity) {
        if (entity.getId() != null) {
            Threat existing = super.get(entity.getId());
            entity.setSpecies(existing.getSpecies());
        }
        entity = super.save(entity);
        speciesService.save(entity.getSpecies());
        return entity;
    }

}