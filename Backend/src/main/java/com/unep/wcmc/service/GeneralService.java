package com.unep.wcmc.service;


import com.unep.wcmc.model.General;
import com.unep.wcmc.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService implements BaseService<General> {

    @Autowired
    GeneralRepository general;

    @Override
    public General save(General entity) {

        return general.save(entity);
    }

    @Override
    public Iterable<General> list() {

        return (List<General>) general.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        general.delete(id);

        return true;
    }

    @Override
    public General get(Long id) {

        return general.findOne(id);
    }
}
