package com.unep.wcmc.service;

import com.unep.wcmc.model.HierarchyClass;
import com.unep.wcmc.repository.HierarchyClassRepository;
import org.springframework.stereotype.Service;

@Service
public final class HierarchyClassService extends AbstractService<HierarchyClass, HierarchyClassRepository> {

    public HierarchyClass findOrSave(String name) {
        HierarchyClass hierarchyClass = repo.findByName(name);
        if (hierarchyClass == null) {
            hierarchyClass = new HierarchyClass(name);
            hierarchyClass = repo.save(hierarchyClass);
        }
        return hierarchyClass;
    }

}
