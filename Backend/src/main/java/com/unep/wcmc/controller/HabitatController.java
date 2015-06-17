package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Habitat;
import com.unep.wcmc.service.HabitatService;

@RestController
@RequestMapping("/habitat")
public class HabitatController extends AbstractController<Habitat, HabitatService> {
}

