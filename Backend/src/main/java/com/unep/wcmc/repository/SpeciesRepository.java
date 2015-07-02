package com.unep.wcmc.repository;

import com.unep.wcmc.model.Species;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Species findByCommonName(String commonName);

    List<Species> findByScientificNameStartingWith(String scientificName, Pageable pageable);

}
