package com.unep.wcmc.service;


import com.unep.wcmc.model.Taxonomy;
import com.unep.wcmc.repository.TaxonomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxonomyService implements BaseService<Taxonomy> {

    @Autowired
    TaxonomyRepository taxonomy;

    @Override
    public Taxonomy save(Taxonomy entity) {

        return taxonomy.save(entity);
    }

    @Override
    public Iterable<Taxonomy> list() {

        return (List<Taxonomy>) taxonomy.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        taxonomy.delete(id);

        return true;
    }

    @Override
    public Taxonomy get(Long id) {

        return taxonomy.findOne(id);
    }
}
