package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.PopulationDynamics;
import com.unep.wcmc.service.PopulationDynamicsService;

@RestController
@RequestMapping("/populationdynamics")
public class PopulationDynamicsController extends AbstractController<PopulationDynamics, PopulationDynamicsService> {
}

