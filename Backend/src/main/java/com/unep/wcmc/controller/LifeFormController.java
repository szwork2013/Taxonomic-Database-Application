package com.unep.wcmc.controller;

import com.unep.wcmc.model.LifeForm;
import com.unep.wcmc.service.LifeFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifeform")
public class LifeFormController {

    @Autowired
    LifeFormService lifeformService;

    @RequestMapping(method= RequestMethod.GET)
    public List<LifeForm> index(){

        return (List<LifeForm>) lifeformService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public LifeForm add(@RequestBody LifeForm lifeform){

        return lifeformService.save(lifeform);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public LifeForm edit(@RequestBody LifeForm lifeform, @PathVariable String id){

        LifeForm obj = lifeformService.get(Long.valueOf(id));

        return lifeformService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public LifeForm view(@PathVariable String id){

        return lifeformService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        lifeformService.delete(Long.valueOf(id));
    }
}

