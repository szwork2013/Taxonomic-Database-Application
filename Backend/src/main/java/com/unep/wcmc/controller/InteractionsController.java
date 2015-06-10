package com.unep.wcmc.controller;

import com.unep.wcmc.model.Interactions;
import com.unep.wcmc.service.InteractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interactions")
public class InteractionsController {

    @Autowired
    InteractionsService interactionsService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Interactions> index(){

        return (List<Interactions>) interactionsService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Interactions add(@RequestBody Interactions interactions){

        return interactionsService.save(interactions);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Interactions edit(@RequestBody Interactions interactions, @PathVariable String id){

        Interactions obj = interactionsService.get(Long.valueOf(id));

        return interactionsService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Interactions view(@PathVariable String id){

        return interactionsService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        interactionsService.delete(Long.valueOf(id));
    }
}

