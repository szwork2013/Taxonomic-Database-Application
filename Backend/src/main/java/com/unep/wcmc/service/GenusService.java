package com.unep.wcmc.service;


import com.unep.wcmc.model.Genus;
import com.unep.wcmc.repository.GenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenusService implements BaseService<Genus> {

    @Autowired
    GenusRepository genus;

    @Override
    public Genus save(Genus entity) {

        return genus.save(entity);
    }

    @Override
    public Iterable<Genus> list() {

        return (List<Genus>) genus.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        genus.delete(id);

        return true;
    }

    @Override
    public Genus get(Long id) {

        return genus.findOne(id);
    }
}
