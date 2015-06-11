package com.unep.wcmc.controller;

import com.unep.wcmc.model.Genus;
import com.unep.wcmc.service.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genus")
public class GenusController {

    @Autowired
    GenusService genusService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Genus> index(){

        return (List<Genus>) genusService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Genus add(@RequestBody Genus genus){

        return genusService.save(genus);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Genus edit(@RequestBody Genus genus, @PathVariable String id){

        Genus obj = genusService.get(Long.valueOf(id));

        return genusService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Genus view(@PathVariable String id){

        return genusService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        genusService.delete(Long.valueOf(id));
    }
}

