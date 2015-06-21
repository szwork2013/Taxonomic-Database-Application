package com.unep.wcmc.service;

import com.unep.wcmc.model.Specie;
import com.unep.wcmc.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class SpecieService extends AbstractService<Specie, SpecieRepository> {

    @Autowired
    private ExtinctionRiskService extinctionRiskService;

    public Specie findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }

    @Override
    public Specie save(Specie specie) {
        extinctionRiskService.processExtinctionRiskCalculation(specie);
        return super.save(specie);
    }

}