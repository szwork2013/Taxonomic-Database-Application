package com.unep.wcmc.controller;

import com.unep.wcmc.model.Reproduction;
import com.unep.wcmc.service.ReproductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reproduction")
public class ReproductionController {

    @Autowired
    ReproductionService reproductionService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Reproduction> index(){

        return (List<Reproduction>) reproductionService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Reproduction add(@RequestBody Reproduction reproduction){

        return reproductionService.save(reproduction);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Reproduction edit(@RequestBody Reproduction reproduction, @PathVariable String id){

        Reproduction obj = reproductionService.get(Long.valueOf(id));

        return reproductionService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Reproduction view(@PathVariable String id){

        return reproductionService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        reproductionService.delete(Long.valueOf(id));
    }
}

