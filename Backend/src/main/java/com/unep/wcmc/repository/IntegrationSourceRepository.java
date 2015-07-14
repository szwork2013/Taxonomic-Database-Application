package com.unep.wcmc.repository;

import com.unep.wcmc.model.IntegrationSource;
import org.springframework.data.repository.CrudRepository;

public interface IntegrationSourceRepository extends CrudRepository<IntegrationSource, Long> {

    IntegrationSource findBySource(IntegrationSource.Source source);

}