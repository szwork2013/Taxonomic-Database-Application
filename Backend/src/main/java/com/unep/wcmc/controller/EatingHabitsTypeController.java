package com.unep.wcmc.controller;

import com.unep.wcmc.model.EatingHabitsType;
import com.unep.wcmc.service.EatingHabitsTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eatinghabitstype")
public class EatingHabitsTypeController extends AbstractController<EatingHabitsType, EatingHabitsTypeService>  {
}
