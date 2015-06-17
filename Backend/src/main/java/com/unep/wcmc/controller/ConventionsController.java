package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Conventions;
import com.unep.wcmc.service.ConventionsService;

@RestController
@RequestMapping("/conventions")
public class ConventionsController extends AbstractController<Conventions, ConventionsService> {
}

