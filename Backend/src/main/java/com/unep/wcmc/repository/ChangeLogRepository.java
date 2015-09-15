package com.unep.wcmc.repository;

import com.unep.wcmc.model.ChangeLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {

    Page<ChangeLog> findBySpeciesId(Long speciesId, Pageable pageable);

    Page<ChangeLog> findBySpeciesIdAndRequestedByUsername(Long speciesId, String username, Pageable pageable);

}
