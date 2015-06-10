package com.unep.wcmc.controller;

import com.unep.wcmc.model.ThreatStatus;
import com.unep.wcmc.service.ThreatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/threatstatus")
public class ThreatStatusController {

    @Autowired
    ThreatStatusService threatstatusService;

    @RequestMapping(method= RequestMethod.GET)
    public List<ThreatStatus> index(){

        return (List<ThreatStatus>) threatstatusService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public ThreatStatus add(@RequestBody ThreatStatus threatstatus){

        return threatstatusService.save(threatstatus);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public ThreatStatus edit(@RequestBody ThreatStatus threatstatus, @PathVariable String id){

        ThreatStatus obj = threatstatusService.get(Long.valueOf(id));

        return threatstatusService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public ThreatStatus view(@PathVariable String id){

        return threatstatusService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        threatstatusService.delete(Long.valueOf(id));
    }
}

