package com.unep.wcmc.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Species;
import com.unep.wcmc.service.SpeciesService;

@RestController
@RequestMapping("/species")
public class SpeciesController extends AbstractController<Species, SpeciesService> {


    @ResponseBody
    @RequestMapping(value = "/autocomplete", produces = "application/json")
    public List<Species> autoComplete(Model model, @RequestParam("query") String query,
                                    @PageableDefault(page = 0, size = 10) Pageable pageable) {



        return service.findByScientificName(query, pageable);
    }
}

