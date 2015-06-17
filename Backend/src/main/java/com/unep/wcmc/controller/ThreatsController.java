package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Threats;
import com.unep.wcmc.service.ThreatsService;

@RestController
@RequestMapping("/threats")
public class ThreatsController extends AbstractController<Threats, ThreatsService> {
}

