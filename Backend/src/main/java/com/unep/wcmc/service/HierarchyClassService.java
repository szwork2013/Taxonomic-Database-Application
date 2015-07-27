package com.unep.wcmc.service;

import com.unep.wcmc.model.HierarchyClass;
import com.unep.wcmc.repository.HierarchyClassRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public final class HierarchyClassService extends AbstractService<HierarchyClass, HierarchyClassRepository> {

    public HierarchyClass findByName(String name) {
        return repo.findByName(name);
    }

    public HierarchyClass findOrSave(HierarchyClass hierarchyClass) {
        if (hierarchyClass != null) {
            HierarchyClass existing = repo.findByName(hierarchyClass.getName());
            if (existing == null) {
                hierarchyClass.setLastModified(new Date());
                hierarchyClass = repo.save(hierarchyClass);
            } else {
                hierarchyClass = existing;
            }
        }
        return hierarchyClass;
    }

}
