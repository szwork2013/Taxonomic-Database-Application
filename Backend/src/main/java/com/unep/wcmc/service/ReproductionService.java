package com.unep.wcmc.service;


import com.unep.wcmc.model.Reproduction;
import com.unep.wcmc.repository.ReproductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReproductionService implements BaseService<Reproduction> {

    @Autowired
    ReproductionRepository reproduction;

    @Override
    public Reproduction save(Reproduction entity) {

        return reproduction.save(entity);
    }

    @Override
    public Iterable<Reproduction> list() {

        return (List<Reproduction>) reproduction.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        reproduction.delete(id);

        return true;
    }

    @Override
    public Reproduction get(Long id) {

        return reproduction.findOne(id);
    }
}
