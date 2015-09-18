package com.unep.wcmc.controller;

import com.unep.wcmc.model.Group;
import com.unep.wcmc.security.ActiveUserAccessor;
import com.unep.wcmc.service.GroupService;
import com.unep.wcmc.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/group")
public class GroupController extends AbstractController<Group, GroupService> {

    @Autowired
    ActiveUserAccessor activeUserAccessor;

    @Autowired
    SpeciesService speciesService;

    @RequestMapping(value ="add" , method= RequestMethod.POST, produces = "application/json")
    public Group add(@RequestBody Group group){

        group.setUser(activeUserAccessor.getActiveUser());
        group.setCreated(new Date());

        return service.save(group);
    }

    @RequestMapping(value = "search", method= RequestMethod.POST, produces = "application/json")
    public Page<Group> findAllByUser(@PageableDefault(page = 0, size = 4) Pageable pageable){
         return service.findAllByUser(activeUserAccessor.getActiveUser(), pageable);
    }
}
