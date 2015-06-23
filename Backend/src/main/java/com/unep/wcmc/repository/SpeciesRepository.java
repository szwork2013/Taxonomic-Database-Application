package com.unep.wcmc.repository;

import com.unep.wcmc.model.Species;

import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Long> {
    
    Species findByCommonName(String commonName);
}
