package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Threat;
import com.unep.wcmc.service.ThreatsService;

@RestController
@RequestMapping("/threats")
public class ThreatsController extends AbstractController<Threat, ThreatsService> {
}

