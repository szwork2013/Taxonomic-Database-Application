package com.unep.wcmc.service;


import com.unep.wcmc.model.Country;
import com.unep.wcmc.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements BaseService<Country> {

    @Autowired
    CountryRepository country;

    @Override
    public Country save(Country entity) {

        return country.save(entity);
    }

    @Override
    public Iterable<Country> list() {

        return (List<Country>) country.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        country.delete(id);

        return true;
    }

    @Override
    public Country get(Long id) {

        return country.findOne(id);
    }
}
