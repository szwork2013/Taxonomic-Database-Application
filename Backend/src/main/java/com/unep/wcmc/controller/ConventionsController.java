package com.unep.wcmc.controller;

import com.unep.wcmc.model.Conventions;
import com.unep.wcmc.service.ConventionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conventions")
public class ConventionsController {

    @Autowired
    ConventionsService conventionsService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Conventions> index(){

        return (List<Conventions>) conventionsService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Conventions add(@RequestBody Conventions conventions){

        return conventionsService.save(conventions);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Conventions edit(@RequestBody Conventions conventions, @PathVariable String id){

        Conventions obj = conventionsService.get(Long.valueOf(id));

        return conventionsService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Conventions view(@PathVariable String id){

        return conventionsService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        conventionsService.delete(Long.valueOf(id));
    }
}

