package com.unep.wcmc.repository;

import com.unep.wcmc.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {}
