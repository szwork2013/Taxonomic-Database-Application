package com.unep.wcmc.service;


import com.unep.wcmc.model.Interactions;
import com.unep.wcmc.repository.InteractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionsService implements BaseService<Interactions> {

    @Autowired
    InteractionsRepository interactions;

    @Override
    public Interactions save(Interactions entity) {

        return interactions.save(entity);
    }

    @Override
    public Iterable<Interactions> list() {

        return (List<Interactions>) interactions.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        interactions.delete(id);

        return true;
    }

    @Override
    public Interactions get(Long id) {

        return interactions.findOne(id);
    }
}
