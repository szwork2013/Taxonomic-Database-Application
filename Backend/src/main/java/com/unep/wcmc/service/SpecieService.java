package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Specie;
import com.unep.wcmc.repository.SpecieRepository;

@Service
public final class SpecieService extends AbstractService<Specie, SpecieRepository> {
    
    public Specie findByCommonName(String commonName) {
        return repo.findByCommonName(commonName);
    }
}
