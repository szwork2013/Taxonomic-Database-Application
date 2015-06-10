package com.unep.wcmc.controller;

import com.unep.wcmc.model.Hierarchy;
import com.unep.wcmc.service.HierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hierarchy")
public class HierarchyController {

    @Autowired
    HierarchyService hierarchyService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Hierarchy> index(){

        return (List<Hierarchy>) hierarchyService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Hierarchy add(@RequestBody Hierarchy hierarchy){

        return hierarchyService.save(hierarchy);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Hierarchy edit(@RequestBody Hierarchy hierarchy, @PathVariable String id){

        Hierarchy obj = hierarchyService.get(Long.valueOf(id));

        return hierarchyService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Hierarchy view(@PathVariable String id){

        return hierarchyService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        hierarchyService.delete(Long.valueOf(id));
    }
}

