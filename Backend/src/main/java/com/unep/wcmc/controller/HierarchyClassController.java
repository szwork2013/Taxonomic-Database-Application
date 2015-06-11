package com.unep.wcmc.controller;

import com.unep.wcmc.model.HierarchyClass;
import com.unep.wcmc.service.HierarchyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hierarchyclass")
public class HierarchyClassController {

    @Autowired
    HierarchyClassService hierarchyclassService;

    @RequestMapping(method= RequestMethod.GET)
    public List<HierarchyClass> index(){

        return (List<HierarchyClass>) hierarchyclassService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public HierarchyClass add(@RequestBody HierarchyClass hierarchyclass){

        return hierarchyclassService.save(hierarchyclass);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public HierarchyClass edit(@RequestBody HierarchyClass hierarchyclass, @PathVariable String id){

        HierarchyClass obj = hierarchyclassService.get(Long.valueOf(id));

        return hierarchyclassService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public HierarchyClass view(@PathVariable String id){

        return hierarchyclassService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        hierarchyclassService.delete(Long.valueOf(id));
    }
}

