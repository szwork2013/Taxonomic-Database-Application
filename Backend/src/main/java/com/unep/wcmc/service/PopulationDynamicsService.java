package com.unep.wcmc.service;


import com.unep.wcmc.model.PopulationDynamics;
import com.unep.wcmc.repository.PopulationDynamicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationDynamicsService implements BaseService<PopulationDynamics> {

    @Autowired
    PopulationDynamicsRepository populationdynamics;

    @Override
    public PopulationDynamics save(PopulationDynamics entity) {

        return populationdynamics.save(entity);
    }

    @Override
    public Iterable<PopulationDynamics> list() {

        return (List<PopulationDynamics>) populationdynamics.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        populationdynamics.delete(id);

        return true;
    }

    @Override
    public PopulationDynamics get(Long id) {

        return populationdynamics.findOne(id);
    }
}
