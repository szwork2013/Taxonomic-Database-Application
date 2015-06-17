package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.service.PhylumService;

@RestController
@RequestMapping("/phylum")
public class PhylumController extends AbstractController<Phylum, PhylumService> {
}

