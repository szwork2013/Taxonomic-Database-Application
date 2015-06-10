package com.unep.wcmc.controller;

import com.unep.wcmc.model.Occurrence;
import com.unep.wcmc.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    OccurrenceService occurrenceService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Occurrence> index(){

        return (List<Occurrence>) occurrenceService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Occurrence add(@RequestBody Occurrence occurrence){

        return occurrenceService.save(occurrence);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Occurrence edit(@RequestBody Occurrence occurrence, @PathVariable String id){

        Occurrence obj = occurrenceService.get(Long.valueOf(id));

        return occurrenceService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Occurrence view(@PathVariable String id){

        return occurrenceService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        occurrenceService.delete(Long.valueOf(id));
    }
}

