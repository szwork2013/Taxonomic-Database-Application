package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.ExtinctionRisk;
import com.unep.wcmc.service.ExtinctionRiskService;

@RestController
@RequestMapping("/extinctionrisk")
public class ExtinctionRiskController extends AbstractController<ExtinctionRisk, ExtinctionRiskService> {
}

