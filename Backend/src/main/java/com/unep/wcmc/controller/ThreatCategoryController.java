package com.unep.wcmc.controller;

import com.unep.wcmc.model.ThreatCategory;
import com.unep.wcmc.service.ThreatCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threatcategory")
public class ThreatCategoryController extends AbstractController<ThreatCategory, ThreatCategoryService> {
}

