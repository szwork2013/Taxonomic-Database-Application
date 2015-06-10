package com.unep.wcmc.service;


import com.unep.wcmc.model.Order;
import com.unep.wcmc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements BaseService<Order> {

    @Autowired
    OrderRepository order;

    @Override
    public Order save(Order entity) {

        return order.save(entity);
    }

    @Override
    public Iterable<Order> list() {

        return (List<Order>) order.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        order.delete(id);

        return true;
    }

    @Override
    public Order get(Long id) {

        return order.findOne(id);
    }
}
