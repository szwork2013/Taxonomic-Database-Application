package com.unep.wcmc.repository;

import com.unep.wcmc.model.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Long>, JpaSpecificationExecutor<Species> {

    Species findByName(String name);

    @Query(value = "select * from species where levenshtein(name, :name) <= 3", nativeQuery = true)
    List<Species> findByNameSoundex(@Param("name") String name);

    List<Species> findByScientificName(String scientificName);

    @Query(value = "select * from species where levenshtein(scientific_name, :scientificName) <= 3", nativeQuery = true)
    List<Species> findByScientificNameSoundex(@Param("scientificName") String scientificName);

    @Query(value = "select s.* from species s join taxonomy t on t.id = s.taxonomy_id where levenshtein(t.species_epiteth, :species) <= 3", nativeQuery = true)
    List<Species> findByTaxonomyHierarchySpeciesEpitethSoundex(@Param("species") String species);

    List<Species> findByTaxonomyHierarchySpeciesEpiteth(String speciesEpiteth);

    @EntityGraph(value = "Species.detail", type = EntityGraph.EntityGraphType.LOAD)
    Species getFetchLoadedById(Long id);

}
