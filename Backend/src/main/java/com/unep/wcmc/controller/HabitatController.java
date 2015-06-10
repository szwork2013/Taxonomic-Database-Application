package com.unep.wcmc.controller;

import com.unep.wcmc.model.Habitat;
import com.unep.wcmc.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitat")
public class HabitatController {

    @Autowired
    HabitatService habitatService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Habitat> index(){

        return (List<Habitat>) habitatService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Habitat add(@RequestBody Habitat habitat){

        return habitatService.save(habitat);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Habitat edit(@RequestBody Habitat habitat, @PathVariable String id){

        Habitat obj = habitatService.get(Long.valueOf(id));

        return habitatService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Habitat view(@PathVariable String id){

        return habitatService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        habitatService.delete(Long.valueOf(id));
    }
}

