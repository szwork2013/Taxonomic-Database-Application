package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.State;
import com.unep.wcmc.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController extends AbstractController<State, StateService> {
}

