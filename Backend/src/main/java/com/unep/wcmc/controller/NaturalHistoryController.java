package com.unep.wcmc.controller;

import com.unep.wcmc.model.NaturalHistory;
import com.unep.wcmc.service.NaturalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/naturalhistory")
public class NaturalHistoryController {

    @Autowired
    NaturalHistoryService naturalhistoryService;

    @RequestMapping(method= RequestMethod.GET)
    public List<NaturalHistory> index(){

        return (List<NaturalHistory>) naturalhistoryService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public NaturalHistory add(@RequestBody NaturalHistory naturalhistory){

        return naturalhistoryService.save(naturalhistory);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public NaturalHistory edit(@RequestBody NaturalHistory naturalhistory, @PathVariable String id){

        NaturalHistory obj = naturalhistoryService.get(Long.valueOf(id));

        return naturalhistoryService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public NaturalHistory view(@PathVariable String id){

        return naturalhistoryService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        naturalhistoryService.delete(Long.valueOf(id));
    }
}

