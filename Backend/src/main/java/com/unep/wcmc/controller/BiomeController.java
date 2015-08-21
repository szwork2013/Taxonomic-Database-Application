package com.unep.wcmc.controller;

import com.unep.wcmc.model.Biome;
import com.unep.wcmc.service.BiomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biome")
public class BiomeController extends AbstractController<Biome, BiomeService> {
}
