package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Gender;
import com.unep.wcmc.service.GenderService;

@RestController
@RequestMapping("/genus")
public class GenderController extends AbstractController<Gender, GenderService> {
}

