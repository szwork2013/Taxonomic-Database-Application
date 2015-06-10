package com.unep.wcmc.controller;

import com.unep.wcmc.model.General;
import com.unep.wcmc.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {

    @Autowired
    GeneralService generalService;

    @RequestMapping(method= RequestMethod.GET)
    public List<General> index(){

        return (List<General>) generalService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public General add(@RequestBody General general){

        return generalService.save(general);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public General edit(@RequestBody General general, @PathVariable String id){

        General obj = generalService.get(Long.valueOf(id));

        return generalService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public General view(@PathVariable String id){

        return generalService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        generalService.delete(Long.valueOf(id));
    }
}

