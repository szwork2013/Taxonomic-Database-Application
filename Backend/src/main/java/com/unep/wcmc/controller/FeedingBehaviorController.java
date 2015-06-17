package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.FeedingBehavior;
import com.unep.wcmc.service.FeedingBehaviorService;

@RestController
@RequestMapping("/feedingbehavior")
public class FeedingBehaviorController extends AbstractController<FeedingBehavior, FeedingBehaviorService> {
}

