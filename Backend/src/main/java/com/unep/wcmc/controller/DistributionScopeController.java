package com.unep.wcmc.controller;

import com.unep.wcmc.model.DistributionScope;
import com.unep.wcmc.service.DistributionScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributionscope")
public class DistributionScopeController {

    @Autowired
    DistributionScopeService distributionscopeService;

    @RequestMapping(method= RequestMethod.GET)
    public List<DistributionScope> index(){

        return (List<DistributionScope>) distributionscopeService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public DistributionScope add(@RequestBody DistributionScope distributionscope){

        return distributionscopeService.save(distributionscope);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public DistributionScope edit(@RequestBody DistributionScope distributionscope, @PathVariable String id){

        DistributionScope obj = distributionscopeService.get(Long.valueOf(id));

        return distributionscopeService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public DistributionScope view(@PathVariable String id){

        return distributionscopeService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        distributionscopeService.delete(Long.valueOf(id));
    }
}

