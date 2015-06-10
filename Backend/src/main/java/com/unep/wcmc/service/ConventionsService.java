package com.unep.wcmc.service;


import com.unep.wcmc.model.Conventions;
import com.unep.wcmc.repository.ConventionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConventionsService implements BaseService<Conventions> {

    @Autowired
    ConventionsRepository conventions;

    @Override
    public Conventions save(Conventions entity) {

        return conventions.save(entity);
    }

    @Override
    public Iterable<Conventions> list() {

        return (List<Conventions>) conventions.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        conventions.delete(id);

        return true;
    }

    @Override
    public Conventions get(Long id) {

        return conventions.findOne(id);
    }
}
