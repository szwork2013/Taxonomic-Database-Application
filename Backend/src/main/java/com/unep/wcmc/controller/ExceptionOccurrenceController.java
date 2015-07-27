package com.unep.wcmc.controller;

import com.unep.wcmc.model.ExceptionOccurrence;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.service.ExceptionOccurrenceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exception")
public class ExceptionOccurrenceController extends AbstractController<ExceptionOccurrence, ExceptionOccurrenceService> {

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/search/{filter}", produces = "application/json")
    public Page<ExceptionOccurrence> search(@PathVariable("filter") String filter,
                                            @PageableDefault(page = 0, size = 20) Pageable pageable) {
        return service.findByFilter(filter, pageable);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/search", produces = "application/json")
    public Page<ExceptionOccurrence> search(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return service.findByFilter("", pageable);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/summary/{type}", produces = "application/json")
    public List<Object[]> summary(@PathVariable("type") String type) {
        return service.findExceptionsSummary(Species.SpeciesType.valueOf(type));
    }

}