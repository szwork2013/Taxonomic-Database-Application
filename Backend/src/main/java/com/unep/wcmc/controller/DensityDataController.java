package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.DensityData;
import com.unep.wcmc.service.DensityDataService;

@RestController
@RequestMapping("/densitydata")
public class DensityDataController extends AbstractController<DensityData, DensityDataService> {
}

