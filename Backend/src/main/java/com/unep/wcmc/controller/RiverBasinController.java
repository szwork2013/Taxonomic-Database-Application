package com.unep.wcmc.controller;

import com.unep.wcmc.model.RiverBasin;
import com.unep.wcmc.service.RiverBasinService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/river")
public class RiverBasinController extends AbstractController<RiverBasin, RiverBasinService> {
}
