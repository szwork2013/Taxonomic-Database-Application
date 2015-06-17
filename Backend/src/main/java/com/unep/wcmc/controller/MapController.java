package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Map;
import com.unep.wcmc.service.MapService;

@RestController
@RequestMapping("/maps")
public class MapController extends AbstractController<Map, MapService> {
}

