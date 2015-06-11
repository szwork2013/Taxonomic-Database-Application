package com.unep.wcmc.controller;

import com.unep.wcmc.model.Specie;
import com.unep.wcmc.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specie")
public class SpecieController {

    @Autowired
    SpecieService specieService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Specie> index(){

        return (List<Specie>) specieService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Specie add(@RequestBody Specie specie){

        return specieService.save(specie);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Specie edit(@RequestBody Specie specie, @PathVariable String id){

        Specie obj = specieService.get(Long.valueOf(id));

        return specieService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Specie view(@PathVariable String id){

        return specieService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        specieService.delete(Long.valueOf(id));
    }
}

