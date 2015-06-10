package com.unep.wcmc.controller;

import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.service.DistributionAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributionarea")
public class DistributionAreaController {

    @Autowired
    DistributionAreaService distributionareaService;

    @RequestMapping(method= RequestMethod.GET)
    public List<DistributionArea> index(){

        return (List<DistributionArea>) distributionareaService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public DistributionArea add(@RequestBody DistributionArea distributionarea){

        return distributionareaService.save(distributionarea);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public DistributionArea edit(@RequestBody DistributionArea distributionarea, @PathVariable String id){

        DistributionArea obj = distributionareaService.get(Long.valueOf(id));

        return distributionareaService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public DistributionArea view(@PathVariable String id){

        return distributionareaService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        distributionareaService.delete(Long.valueOf(id));
    }
}

