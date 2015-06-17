package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Specie;
import com.unep.wcmc.service.SpecieService;

@RestController
@RequestMapping("/specie")
public class SpecieController extends AbstractController<Specie, SpecieService> {
}

