package com.unep.wcmc.repository;

import com.unep.wcmc.model.Taxonomy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaxonomyRepository extends CrudRepository<Taxonomy, Long> {

//    @Query(value = "select * from taxonomy where levenshtein(taxonomy.species, :species)  <= 2", nativeQuery = true)
//    List<Taxonomy> findByHierarchySpeciesSoundex(@Param("species") String species);

    @Query(value = "select t from Taxonomy t where (:kingdom = 'null' or t.hierarchy.kingdom.name = :kingdom) " +
                    "and (:phylum = 'null' or t.hierarchy.phylum.name = :phylum) " +
                    "and (:hierarchyClass = 'null' or t.hierarchy.hierarchyClass.name = :hierarchyClass) " +
                    "and (:order = 'null' or t.hierarchy.order.name = :order) " +
                    "and (:family = 'null' or t.hierarchy.family.name = :family) " +
                    "and (:genus = 'null' or t.hierarchy.genus.name = :genus)")
    List<Taxonomy> findByHierarchyValues(@Param("kingdom") String kingdom, @Param("phylum") String phylum,
                                         @Param("hierarchyClass") String hierarchyClass, @Param("order") String order,
                                         @Param("family") String family, @Param("genus") String genus);

}
