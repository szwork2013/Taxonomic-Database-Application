package com.unep.wcmc.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Species;
import com.unep.wcmc.model.filter.SpeciesFilter;
import com.unep.wcmc.service.SpeciesService;

@RestController
@RequestMapping("/species")
public class SpeciesController extends AbstractController<Species, SpeciesService> {

    @RequestMapping(method = RequestMethod.POST, value = "/autocomplete", produces = "application/json")
    public Page<Species> autoComplete(@Valid @RequestBody SpeciesFilter filter,
    								  @PageableDefault(page = 0, size = 30) Pageable pageable) {
        return service.findAll(filter, pageable);
    }
}

