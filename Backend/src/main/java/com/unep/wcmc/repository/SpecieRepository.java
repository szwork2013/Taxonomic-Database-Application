package com.unep.wcmc.repository;

import com.unep.wcmc.model.Specie;

import org.springframework.data.repository.CrudRepository;

public interface SpecieRepository extends CrudRepository<Specie, Long> {
    
    Specie findByCommonName(String commonName);
}
