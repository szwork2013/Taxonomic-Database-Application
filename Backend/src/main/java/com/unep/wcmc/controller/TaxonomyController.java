package com.unep.wcmc.controller;

import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.service.TaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxonomy")
public class TaxonomyController {

    @Autowired
    TaxonomyService taxonomyService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Taxonomy> index(){

        return (List<Taxonomy>) taxonomyService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Taxonomy add(@RequestBody Taxonomy taxonomy){

        return taxonomyService.save(taxonomy);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Taxonomy edit(@RequestBody Taxonomy taxonomy, @PathVariable String id){

        Taxonomy obj = taxonomyService.get(Long.valueOf(id));

        return taxonomyService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Taxonomy view(@PathVariable String id){

        return taxonomyService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        taxonomyService.delete(Long.valueOf(id));
    }
}

