package com.unep.wcmc.controller;

import com.unep.wcmc.model.Family;
import com.unep.wcmc.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Family> index(){

        return (List<Family>) familyService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Family add(@RequestBody Family family){

        return familyService.save(family);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Family edit(@RequestBody Family family, @PathVariable String id){

        Family obj = familyService.get(Long.valueOf(id));

        return familyService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Family view(@PathVariable String id){

        return familyService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        familyService.delete(Long.valueOf(id));
    }
}

