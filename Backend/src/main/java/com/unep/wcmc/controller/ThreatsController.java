package com.unep.wcmc.controller;

import com.unep.wcmc.model.Threats;
import com.unep.wcmc.service.ThreatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/threats")
public class ThreatsController {

    @Autowired
    ThreatsService threatsService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Threats> index(){

        return (List<Threats>) threatsService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Threats add(@RequestBody Threats threats){

        return threatsService.save(threats);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Threats edit(@RequestBody Threats threats, @PathVariable String id){

        Threats obj = threatsService.get(Long.valueOf(id));

        return threatsService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Threats view(@PathVariable String id){

        return threatsService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        threatsService.delete(Long.valueOf(id));
    }
}

