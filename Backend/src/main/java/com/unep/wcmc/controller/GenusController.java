package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Gender;
import com.unep.wcmc.service.GenusService;

@RestController
@RequestMapping("/genus")
public class GenusController extends AbstractController<Gender, GenusService> {
}

