package com.unep.wcmc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.model.Country;
import com.unep.wcmc.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController extends AbstractController<Country, CountryService> {
}

