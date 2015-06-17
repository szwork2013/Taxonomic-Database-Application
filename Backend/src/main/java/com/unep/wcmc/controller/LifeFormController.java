package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.LifeForm;
import com.unep.wcmc.service.LifeFormService;

@RestController
@RequestMapping("/lifeform")
public class LifeFormController extends AbstractController<LifeForm, LifeFormService> {
}

