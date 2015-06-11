package com.unep.wcmc.controller;

import com.unep.wcmc.model.Order;
import com.unep.wcmc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Order> index(){

        return (List<Order>) orderService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Order add(@RequestBody Order order){

        return orderService.save(order);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Order edit(@RequestBody Order order, @PathVariable String id){

        Order obj = orderService.get(Long.valueOf(id));

        return orderService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Order view(@PathVariable String id){

        return orderService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        orderService.delete(Long.valueOf(id));
    }
}

