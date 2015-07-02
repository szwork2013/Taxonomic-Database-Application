package com.unep.wcmc.controller;

import com.unep.wcmc.model.Species;
import com.unep.wcmc.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

