package com.unep.wcmc.controller;

import com.unep.wcmc.model.Conservation;
import com.unep.wcmc.service.ConservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conservation")
public class ConservationController {

    @Autowired
    ConservationService conservationService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Conservation> index(){

        return (List<Conservation>) conservationService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Conservation add(@RequestBody Conservation conservation){

        return conservationService.save(conservation);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Conservation edit(@RequestBody Conservation conservation, @PathVariable String id){

        Conservation obj = conservationService.get(Long.valueOf(id));

        return conservationService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Conservation view(@PathVariable String id){

        return conservationService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        conservationService.delete(Long.valueOf(id));
    }
}

