package com.unep.wcmc.service;


import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.repository.PhylumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhylumService implements BaseService<Phylum> {

    @Autowired
    PhylumRepository phylum;

    @Override
    public Phylum save(Phylum entity) {

        return phylum.save(entity);
    }

    @Override
    public Iterable<Phylum> list() {

        return (List<Phylum>) phylum.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        phylum.delete(id);

        return true;
    }

    @Override
    public Phylum get(Long id) {

        return phylum.findOne(id);
    }
}
