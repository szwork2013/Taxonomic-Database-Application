package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Conservation;
import com.unep.wcmc.service.ConservationService;

@RestController
@RequestMapping("/conservation")
public class ConservationController extends AbstractController<Conservation, ConservationService> {
}
