package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Reproduction;
import com.unep.wcmc.service.ReproductionService;

@RestController
@RequestMapping("/reproduction")
public class ReproductionController extends AbstractController<Reproduction, ReproductionService> {
}

