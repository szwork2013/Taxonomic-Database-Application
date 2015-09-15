package com.unep.wcmc.controller;

import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.service.ChangeLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/changelog")
public class ChangeLogController extends AbstractController<ChangeLog, ChangeLogService> {

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/search/{speciesId}", produces = "application/json")
    public Page<ChangeLog> search(@PathVariable("speciesId") Long speciesId,
                                  @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return service.searchAll(speciesId, pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/approve/{id}", produces = "application/json")
    public ChangeLog approve(@PathVariable("id") Long id) {
        return service.approveChange(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/reject/{id}", produces = "application/json")
    public ChangeLog reject(@PathVariable("id") Long id) {
        return service.rejectChange(id);
    }


}