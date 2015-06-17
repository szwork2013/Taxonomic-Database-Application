package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Order;
import com.unep.wcmc.repository.OrderRepository;

@Service
public class OrderService extends AbstractService<Order, OrderRepository> {
}
