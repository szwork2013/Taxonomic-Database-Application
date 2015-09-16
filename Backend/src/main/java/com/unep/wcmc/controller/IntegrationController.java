package com.unep.wcmc.controller;

import com.unep.wcmc.domain.SuccessResponse;
import com.unep.wcmc.model.IntegrationHistory;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/integration")
public class IntegrationController {

    @Autowired
    private IntegrationService service;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/start/{source}", method = RequestMethod.GET)
    public Object start(@PathVariable String source) {
        try {
            service.start(IntegrationSource.Source.valueOf(source));
            return new SuccessResponse("ok");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/stop/{source}", method = RequestMethod.GET)
    public Object stop(@PathVariable String source) {
        try {
            service.stop(IntegrationSource.Source.valueOf(source));
            return new SuccessResponse("ok");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(path = "/history/{source}", method = RequestMethod.GET)
    //@Secured("ADMIN")
    public IntegrationHistory getLatestHistory(@PathVariable String source) {
        return service.findLatestHistory(IntegrationSource.Source.valueOf(source));
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/history", method = RequestMethod.GET)
    public List<IntegrationHistory> getLatestHistory() {
        return service.findAllLatestHistory();
    }


}