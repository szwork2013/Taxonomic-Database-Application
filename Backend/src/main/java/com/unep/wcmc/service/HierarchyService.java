package com.unep.wcmc.service;


import com.unep.wcmc.model.Hierarchy;
import com.unep.wcmc.repository.HierarchyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HierarchyService implements BaseService<Hierarchy> {

    @Autowired
    HierarchyRepository hierarchy;

    @Override
    public Hierarchy save(Hierarchy entity) {

        return hierarchy.save(entity);
    }

    @Override
    public Iterable<Hierarchy> list() {

        return (List<Hierarchy>) hierarchy.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        hierarchy.delete(id);

        return true;
    }

    @Override
    public Hierarchy get(Long id) {

        return hierarchy.findOne(id);
    }
}
