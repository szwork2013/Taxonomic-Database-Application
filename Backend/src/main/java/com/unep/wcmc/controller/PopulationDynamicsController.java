package com.unep.wcmc.controller;

import com.unep.wcmc.model.PopulationDynamics;
import com.unep.wcmc.service.PopulationDynamicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/populationdynamics")
public class PopulationDynamicsController {

    @Autowired
    PopulationDynamicsService populationdynamicsService;

    @RequestMapping(method= RequestMethod.GET)
    public List<PopulationDynamics> index(){

        return (List<PopulationDynamics>) populationdynamicsService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public PopulationDynamics add(@RequestBody PopulationDynamics populationdynamics){

        return populationdynamicsService.save(populationdynamics);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public PopulationDynamics edit(@RequestBody PopulationDynamics populationdynamics, @PathVariable String id){

        PopulationDynamics obj = populationdynamicsService.get(Long.valueOf(id));

        return populationdynamicsService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public PopulationDynamics view(@PathVariable String id){

        return populationdynamicsService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        populationdynamicsService.delete(Long.valueOf(id));
    }
}

