package com.unep.wcmc.repository;

import com.unep.wcmc.model.Taxonomy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaxonomyRepository extends CrudRepository<Taxonomy, Long> {

    Taxonomy findByHierarchySpeciesContaining(String species);

    @Query(value = "select * from taxonomy where levenshtein(taxonomy.species, :species)  <= 2", nativeQuery = true)
    List<Taxonomy> findByHierarchySpeciesSoundex(@Param("species") String species);

}
