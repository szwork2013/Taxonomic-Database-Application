package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.DistributionScope;
import com.unep.wcmc.service.DistributionScopeService;

@RestController
@RequestMapping("/distributionscope")
public class DistributionScopeController extends AbstractController<DistributionScope, DistributionScopeService> {
}

