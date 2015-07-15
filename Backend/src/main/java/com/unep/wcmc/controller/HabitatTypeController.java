package com.unep.wcmc.controller;

import com.unep.wcmc.model.HabitatType;
import com.unep.wcmc.service.HabitatTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitattype")
public class HabitatTypeController extends AbstractController<HabitatType, HabitatTypeService> {
}
