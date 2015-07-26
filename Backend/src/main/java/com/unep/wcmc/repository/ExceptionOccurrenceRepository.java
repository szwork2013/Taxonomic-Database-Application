package com.unep.wcmc.repository;

import com.unep.wcmc.model.ExceptionOccurrence;
import com.unep.wcmc.model.filter.SpeciesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExceptionOccurrenceRepository extends CrudRepository<ExceptionOccurrence, Long> {

    @Query(value = "select e from ExceptionOccurrence e join fetch e.active a join fetch e.suggested s where e.title like :filter",
        countQuery = "select e.id from ExceptionOccurrence e")
    Page<ExceptionOccurrence> findByFilter(@Param("filter") String filter, Pageable pageable);

    Page<ExceptionOccurrence> findByTitleContaining(String title, Pageable pageable);
}