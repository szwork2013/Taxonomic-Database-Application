package com.unep.wcmc.service;


import com.unep.wcmc.model.Habitat;
import com.unep.wcmc.repository.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService implements BaseService<Habitat> {

    @Autowired
    HabitatRepository habitat;

    @Override
    public Habitat save(Habitat entity) {

        return habitat.save(entity);
    }

    @Override
    public Iterable<Habitat> list() {

        return (List<Habitat>) habitat.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        habitat.delete(id);

        return true;
    }

    @Override
    public Habitat get(Long id) {

        return habitat.findOne(id);
    }
}
