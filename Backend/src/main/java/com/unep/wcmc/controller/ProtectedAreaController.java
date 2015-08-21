package com.unep.wcmc.controller;

import com.unep.wcmc.model.ProtectedArea;
import com.unep.wcmc.service.ProtectedAreaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected_area")
public class ProtectedAreaController extends AbstractController<ProtectedArea, ProtectedAreaService> {
}
