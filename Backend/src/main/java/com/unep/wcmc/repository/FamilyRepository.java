package com.unep.wcmc.repository;

import com.unep.wcmc.model.Family;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family, Long> {

    Family findByName(String name);

}
