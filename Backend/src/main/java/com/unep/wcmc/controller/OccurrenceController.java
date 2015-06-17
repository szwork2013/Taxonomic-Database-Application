package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Occurrence;
import com.unep.wcmc.service.OccurrenceService;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController extends AbstractController<Occurrence, OccurrenceService> {
}

