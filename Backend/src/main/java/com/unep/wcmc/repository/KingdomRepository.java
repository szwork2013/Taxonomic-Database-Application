package com.unep.wcmc.repository;

import com.unep.wcmc.model.Kingdom;
import org.springframework.data.repository.CrudRepository;

public interface KingdomRepository extends CrudRepository<Kingdom, Long> {

    Kingdom findByName(String name);

}
