package com.unep.wcmc.controller;

import com.unep.wcmc.model.Comment;
import com.unep.wcmc.model.User;
import com.unep.wcmc.security.ActiveUserAccessor;
import com.unep.wcmc.service.CommentService;
import com.unep.wcmc.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;


@RestController
@RequestMapping("/comment")
public class CommentController extends AbstractController<Comment, CommentService> {

    @Autowired
    ActiveUserAccessor activeUserAccessor;

    @Autowired
    SpeciesService speciesService;

    @RequestMapping(method= RequestMethod.POST, produces = "application/json")
    public Comment add(@RequestBody Comment comment){

        comment.setUser(activeUserAccessor.getActiveUser());
        comment.setCreated(new Date());

        return service.save(comment);
    }

    @RequestMapping(value = "search", method= RequestMethod.POST, produces = "application/json")
    public Page<Comment> findAllBySpecie(@RequestParam("specie_id") Long specie_id, @PageableDefault(page = 0, size = 4) Pageable pageable){
         return service.findAllBySpecie(speciesService.get(specie_id), pageable);
    }
}
