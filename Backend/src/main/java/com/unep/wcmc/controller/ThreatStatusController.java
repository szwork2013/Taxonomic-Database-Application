package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.ThreatStatus;
import com.unep.wcmc.service.ThreatStatusService;

@RestController
@RequestMapping("/threatstatus")
public class ThreatStatusController extends AbstractController<ThreatStatus, ThreatStatusService> {
}

