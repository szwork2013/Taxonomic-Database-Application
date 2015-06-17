package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.service.TaxonomyService;

@RestController
@RequestMapping("/taxonomy")
public class TaxonomyController extends AbstractController<Taxonomy, TaxonomyService> {
}

