package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.PopulationTrend;
import com.unep.wcmc.service.PopulationTrendService;

@RestController
@RequestMapping("/populationtrend")
public class PopulationTrendController extends AbstractController<PopulationTrend, PopulationTrendService> {
}

