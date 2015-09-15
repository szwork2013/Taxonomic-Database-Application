package com.unep.wcmc.controller;

import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.service.ChangeLogService;
import com.unep.wcmc.service.PhylumService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/changelog")
public class ChangeLogController extends AbstractController<ChangeLog, ChangeLogService> {
}