package com.unep.wcmc.controller;

import com.unep.wcmc.model.Map;
import com.unep.wcmc.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapController {

    @Autowired
    MapService mapService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Map> index(){

        return (List<Map>) mapService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Map add(@RequestBody Map map){

        return mapService.save(map);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Map edit(@RequestBody Map map, @PathVariable String id){

        Map obj = mapService.get(Long.valueOf(id));

        return mapService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Map view(@PathVariable String id){

        return mapService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        mapService.delete(Long.valueOf(id));
    }
}

