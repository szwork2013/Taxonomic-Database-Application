package com.unep.wcmc.service;


import com.unep.wcmc.model.HierarchyClass;
import com.unep.wcmc.repository.HierarchyClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HierarchyClassService implements BaseService<HierarchyClass> {

    @Autowired
    HierarchyClassRepository hierarchyclass;

    @Override
    public HierarchyClass save(HierarchyClass entity) {

        return hierarchyclass.save(entity);
    }

    @Override
    public Iterable<HierarchyClass> list() {

        return (List<HierarchyClass>) hierarchyclass.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        hierarchyclass.delete(id);

        return true;
    }

    @Override
    public HierarchyClass get(Long id) {

        return hierarchyclass.findOne(id);
    }
}
