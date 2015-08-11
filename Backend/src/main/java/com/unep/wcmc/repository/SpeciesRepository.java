package com.unep.wcmc.repository;

import com.unep.wcmc.model.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Long>, JpaSpecificationExecutor<Species> {

    Species findByName(String name);

    List<Species> findByScientificName(String scientificName);

    @Query(value = "select * from species where levenshtein(scientific_name, :scientificName) <= 3", nativeQuery = true)
    List<Species> findByScientificNameSoundex(@Param("scientificName") String scientificName);

    //List<Species> findByTaxonomyHierarchySpecies(String species);

    //@Query(value = "select s.* from species s join taxonomy t on t.id = s.taxonomy_id where levenshtein(t.species, :species) <= 3", nativeQuery = true)
    //List<Species> findByTaxonomySpeciesSoundex(@Param("species") String species);

}
