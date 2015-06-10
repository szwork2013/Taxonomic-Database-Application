package com.unep.wcmc.controller;

import com.unep.wcmc.model.DensityData;
import com.unep.wcmc.service.DensityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/densitydata")
public class DensityDataController {

    @Autowired
    DensityDataService densitydataService;

    @RequestMapping(method= RequestMethod.GET)
    public List<DensityData> index(){

        return (List<DensityData>) densitydataService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public DensityData add(@RequestBody DensityData densitydata){

        return densitydataService.save(densitydata);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public DensityData edit(@RequestBody DensityData densitydata, @PathVariable String id){

        DensityData obj = densitydataService.get(Long.valueOf(id));

        return densitydataService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public DensityData view(@PathVariable String id){

        return densitydataService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        densitydataService.delete(Long.valueOf(id));
    }
}

