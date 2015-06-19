package com.unep.wcmc.repository;

import com.unep.wcmc.model.HierarchyClass;
import org.springframework.data.repository.CrudRepository;

public interface HierarchyClassRepository extends CrudRepository<HierarchyClass, Long> {

    HierarchyClass findByName(String name);

}
