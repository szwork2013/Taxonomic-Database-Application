package com.unep.wcmc.repository;

import com.unep.wcmc.model.IntegrationHistory;
import com.unep.wcmc.model.IntegrationSource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IntegrationHistoryRepository extends CrudRepository<IntegrationHistory, Long> {

    List<IntegrationHistory> findByIntegrationSourceAndCompleted(IntegrationSource source,
                                                                       boolean completed);

    IntegrationHistory findFirstByIntegrationSourceSourceOrderByUpdatedAtDesc(IntegrationSource.Source source);

}