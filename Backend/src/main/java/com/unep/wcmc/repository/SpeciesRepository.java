package com.unep.wcmc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.unep.wcmc.model.Species;

public interface SpeciesRepository extends JpaRepository<Species, Long>, JpaSpecificationExecutor<Species> {

    Species findByCommonName(String commonName);

    Page<Species> findByCommonNameStartingWith(String commonName, Pageable pageable);

    Species findByScientificName(String scientificName);

}
