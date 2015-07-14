package com.unep.wcmc.service;

import com.unep.wcmc.model.HierarchyClass;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.repository.HierarchyClassRepository;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class HierarchyClassService extends AbstractService<HierarchyClass, HierarchyClassRepository> {

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public HierarchyClass findOrSave(HierarchyClass hierarchyClass) {
        if (hierarchyClass != null) {
            HierarchyClass existing = repo.findByName(hierarchyClass.getName());
            if (existing == null) {
                if (hierarchyClass.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(hierarchyClass.getIntegrationSource().getSource());
                    hierarchyClass.setIntegrationSource(integration);
                }
                hierarchyClass = repo.save(hierarchyClass);
            } else {
                hierarchyClass = existing;
            }
        }
        return hierarchyClass;
    }

}
