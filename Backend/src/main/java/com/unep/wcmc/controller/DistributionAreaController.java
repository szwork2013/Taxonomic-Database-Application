package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.service.DistributionAreaService;

@RestController
@RequestMapping("/distributionarea")
public class DistributionAreaController extends AbstractController<DistributionArea, DistributionAreaService> {
}

