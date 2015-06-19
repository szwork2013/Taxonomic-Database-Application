package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.HierarchyOrder;
import com.unep.wcmc.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController extends AbstractController<HierarchyOrder, OrderService> {
}

