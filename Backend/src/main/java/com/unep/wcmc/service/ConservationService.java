package com.unep.wcmc.service;


import com.unep.wcmc.model.Conservation;
import com.unep.wcmc.repository.ConservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConservationService implements BaseService<Conservation> {

    @Autowired
    ConservationRepository conservation;

    @Override
    public Conservation save(Conservation entity) {

        return conservation.save(entity);
    }

    @Override
    public Iterable<Conservation> list() {

        return (List<Conservation>) conservation.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        conservation.delete(id);

        return true;
    }

    @Override
    public Conservation get(Long id) {

        return conservation.findOne(id);
    }
}
