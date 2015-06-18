package com.unep.wcmc.repository;

import com.unep.wcmc.model.Threat;
import org.springframework.data.repository.CrudRepository;

public interface ThreatsRepository extends CrudRepository<Threat, Long> {}
