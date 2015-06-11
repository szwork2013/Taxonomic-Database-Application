package com.unep.wcmc.controller;

import com.unep.wcmc.model.TaxonomyGeneral;
import com.unep.wcmc.service.TaxonomyGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general")
public class TaxonomyGeneralController {

    @Autowired
    TaxonomyGeneralService taxonomyGeneralService;

    @RequestMapping(method= RequestMethod.GET)
    public List<TaxonomyGeneral> index(){

        return (List<TaxonomyGeneral>) taxonomyGeneralService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public TaxonomyGeneral add(@RequestBody TaxonomyGeneral taxonomyGeneral){

        return taxonomyGeneralService.save(taxonomyGeneral);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public TaxonomyGeneral edit(@RequestBody TaxonomyGeneral taxonomyGeneral, @PathVariable String id){

        TaxonomyGeneral obj = taxonomyGeneralService.get(Long.valueOf(id));

        return taxonomyGeneralService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public TaxonomyGeneral view(@PathVariable String id){

        return taxonomyGeneralService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        taxonomyGeneralService.delete(Long.valueOf(id));
    }
}

