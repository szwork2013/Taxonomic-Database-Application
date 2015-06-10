package com.unep.wcmc.controller;

import com.unep.wcmc.model.ExtinctionRisk;
import com.unep.wcmc.service.ExtinctionRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extinctionrisk")
public class ExtinctionRiskController {

    @Autowired
    ExtinctionRiskService extinctionriskService;

    @RequestMapping(method= RequestMethod.GET)
    public List<ExtinctionRisk> index(){

        return (List<ExtinctionRisk>) extinctionriskService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public ExtinctionRisk add(@RequestBody ExtinctionRisk extinctionrisk){

        return extinctionriskService.save(extinctionrisk);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public ExtinctionRisk edit(@RequestBody ExtinctionRisk extinctionrisk, @PathVariable String id){

        ExtinctionRisk obj = extinctionriskService.get(Long.valueOf(id));

        return extinctionriskService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public ExtinctionRisk view(@PathVariable String id){

        return extinctionriskService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        extinctionriskService.delete(Long.valueOf(id));
    }
}

