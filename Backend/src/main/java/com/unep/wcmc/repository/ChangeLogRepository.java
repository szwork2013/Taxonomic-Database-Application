package com.unep.wcmc.repository;

import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChangeLogRepository extends CrudRepository<ChangeLog, Long> {

    List<ChangeLog> findByRequestedByUsername(String username);

}
