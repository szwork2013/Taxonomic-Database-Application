package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.HierarchyOrder;
import com.unep.wcmc.repository.HierarchyOrderRepository;

@Service
public class OrderService extends AbstractService<HierarchyOrder, HierarchyOrderRepository> {
}
