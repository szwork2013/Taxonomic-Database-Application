package com.unep.wcmc.repository;

import com.unep.wcmc.model.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {

    State findByCode(String code);

}
