package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.HierarchyClass;
import com.unep.wcmc.service.HierarchyClassService;

@RestController
@RequestMapping("/hierarchyclass")
public class HierarchyClassController extends AbstractController<HierarchyClass, HierarchyClassService> {
}

