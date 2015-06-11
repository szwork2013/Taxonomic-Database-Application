package com.unep.wcmc.service;


import com.unep.wcmc.model.Map;
import com.unep.wcmc.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService implements BaseService<Map> {

    @Autowired
    MapRepository maps;

    @Override
    public Map save(Map entity) {

        return maps.save(entity);
    }

    @Override
    public Iterable<Map> list() {

        return (List<Map>) maps.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        maps.delete(id);

        return true;
    }

    @Override
    public Map get(Long id) {

        return maps.findOne(id);
    }
}
