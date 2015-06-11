package com.unep.wcmc.service;


import com.unep.wcmc.model.Specie;
import com.unep.wcmc.repository.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecieService implements BaseService<Specie> {

    @Autowired
    SpecieRepository specie;

    @Override
    public Specie save(Specie entity) {

        return specie.save(entity);
    }

    @Override
    public Iterable<Specie> list() {

        return (List<Specie>) specie.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        specie.delete(id);

        return true;
    }

    @Override
    public Specie get(Long id) {

        return specie.findOne(id);
    }
}
