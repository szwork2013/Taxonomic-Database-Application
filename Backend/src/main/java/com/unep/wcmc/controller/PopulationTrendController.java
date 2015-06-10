package com.unep.wcmc.controller;

import com.unep.wcmc.model.PopulationTrend;
import com.unep.wcmc.service.PopulationTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/populationtrend")
public class PopulationTrendController {

    @Autowired
    PopulationTrendService populationtrendService;

    @RequestMapping(method= RequestMethod.GET)
    public List<PopulationTrend> index(){

        return (List<PopulationTrend>) populationtrendService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public PopulationTrend add(@RequestBody PopulationTrend populationtrend){

        return populationtrendService.save(populationtrend);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public PopulationTrend edit(@RequestBody PopulationTrend populationtrend, @PathVariable String id){

        PopulationTrend obj = populationtrendService.get(Long.valueOf(id));

        return populationtrendService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public PopulationTrend view(@PathVariable String id){

        return populationtrendService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        populationtrendService.delete(Long.valueOf(id));
    }
}

