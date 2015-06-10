package com.unep.wcmc.controller;

import com.unep.wcmc.model.Country;
import com.unep.wcmc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @RequestMapping(method= RequestMethod.GET)
    public List<Country> index(){

        return (List<Country>) countryService.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public Country add(@RequestBody Country country){

        return countryService.save(country);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public Country edit(@RequestBody Country country, @PathVariable String id){

        Country obj = countryService.get(Long.valueOf(id));

        return countryService.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public Country view(@PathVariable String id){

        return countryService.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id){

        countryService.delete(Long.valueOf(id));
    }
}

