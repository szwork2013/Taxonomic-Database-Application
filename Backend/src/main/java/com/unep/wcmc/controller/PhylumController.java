package com.unep.wcmc.controller;

import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.service.PhylumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phylum")
public class PhylumController {

    @Autowired
    PhylumService phylumService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Phylum> index(){

        return (List<Phylum>) phylumService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Phylum add(@RequestBody Phylum phylum){

        return phylumService.save(phylum);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Phylum edit(@RequestBody Phylum phylum, @PathVariable String id){

        Phylum obj = phylumService.get(Long.valueOf(id));

        return phylumService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Phylum view(@PathVariable String id){

        return phylumService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        phylumService.delete(Long.valueOf(id));
    }
}

