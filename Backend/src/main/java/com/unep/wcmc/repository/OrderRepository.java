package com.unep.wcmc.repository;

import com.unep.wcmc.model.HierarchyOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<HierarchyOrder, Long> {}
