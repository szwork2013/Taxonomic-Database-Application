package com.unep.wcmc.controller;

import com.unep.wcmc.model.FeedingBehavior;
import com.unep.wcmc.service.FeedingBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedingbehavior")
public class FeedingBehaviorController {

    @Autowired
    FeedingBehaviorService feedingbehaviorService;

    @RequestMapping(method= RequestMethod.GET)
    public List<FeedingBehavior> index(){

        return (List<FeedingBehavior>) feedingbehaviorService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public FeedingBehavior add(@RequestBody FeedingBehavior feedingbehavior){

        return feedingbehaviorService.save(feedingbehavior);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public FeedingBehavior edit(@RequestBody FeedingBehavior feedingbehavior, @PathVariable String id){

        FeedingBehavior obj = feedingbehaviorService.get(Long.valueOf(id));

        return feedingbehaviorService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public FeedingBehavior view(@PathVariable String id){

        return feedingbehaviorService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        feedingbehaviorService.delete(Long.valueOf(id));
    }
}

