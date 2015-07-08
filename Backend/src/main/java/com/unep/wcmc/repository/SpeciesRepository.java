package com.unep.wcmc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unep.wcmc.model.Species;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Species findByCommonName(String commonName);
    Page<Species> findByCommonNameStartingWith(String commonName, Pageable pageable);
}
