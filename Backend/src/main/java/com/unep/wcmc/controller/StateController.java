package com.unep.wcmc.controller;

import com.unep.wcmc.model.State;
import com.unep.wcmc.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateService stateService;

    @RequestMapping(method= RequestMethod.GET)
    public List<State> index(){

        return (List<State>) stateService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public State add(@RequestBody State state){

        return stateService.save(state);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public State edit(@RequestBody State state, @PathVariable String id){

        State obj = stateService.get(Long.valueOf(id));

        return stateService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public State view(@PathVariable String id){

        return stateService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        stateService.delete(Long.valueOf(id));
    }
}

