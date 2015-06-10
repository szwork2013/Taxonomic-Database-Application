package com.unep.wcmc.service;


import com.unep.wcmc.model.Maps;
import com.unep.wcmc.repository.MapsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapsService implements BaseService<Maps> {

    @Autowired
    MapsRepository maps;

    @Override
    public Maps save(Maps entity) {

        return maps.save(entity);
    }

    @Override
    public Iterable<Maps> list() {

        return (List<Maps>) maps.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        maps.delete(id);

        return true;
    }

    @Override
    public Maps get(Long id) {

        return maps.findOne(id);
    }
}
