package com.unep.wcmc.service;


import com.unep.wcmc.model.Occurrence;
import com.unep.wcmc.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccurrenceService implements BaseService<Occurrence> {

    @Autowired
    OccurrenceRepository occurrence;

    @Override
    public Occurrence save(Occurrence entity) {

        return occurrence.save(entity);
    }

    @Override
    public Iterable<Occurrence> list() {

        return (List<Occurrence>) occurrence.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        occurrence.delete(id);

        return true;
    }

    @Override
    public Occurrence get(Long id) {

        return occurrence.findOne(id);
    }
}
