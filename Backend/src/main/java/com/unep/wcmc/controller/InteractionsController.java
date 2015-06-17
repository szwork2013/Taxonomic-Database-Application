package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Interactions;
import com.unep.wcmc.service.InteractionsService;

@RestController
@RequestMapping("/interactions")
public class InteractionsController extends AbstractController<Interactions, InteractionsService> {
}

