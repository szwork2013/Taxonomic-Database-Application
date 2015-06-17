package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.TaxonomyGeneral;
import com.unep.wcmc.service.TaxonomyGeneralService;

@RestController
@RequestMapping("/general")
public class TaxonomyGeneralController extends AbstractController<TaxonomyGeneral, TaxonomyGeneralService> {
}

