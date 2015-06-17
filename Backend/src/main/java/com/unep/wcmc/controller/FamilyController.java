package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Family;
import com.unep.wcmc.service.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController extends AbstractController<Family, FamilyService> {
}

