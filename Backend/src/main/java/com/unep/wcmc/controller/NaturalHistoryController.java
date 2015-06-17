package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.NaturalHistory;
import com.unep.wcmc.service.NaturalHistoryService;

@RestController
@RequestMapping("/naturalhistory")
public class NaturalHistoryController extends AbstractController<NaturalHistory, NaturalHistoryService> {
}

