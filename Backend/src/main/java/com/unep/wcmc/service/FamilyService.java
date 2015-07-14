package com.unep.wcmc.service;

import com.unep.wcmc.model.Family;
import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.repository.FamilyRepository;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class FamilyService extends AbstractService<Family, FamilyRepository> {

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public Family findOrSave(Family family) {
        if (family != null) {
            Family existing = repo.findByName(family.getName());
            if (existing == null) {
                if (family.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(family.getIntegrationSource().getSource());
                    family.setIntegrationSource(integration);
                }
                family = repo.save(family);
            } else {
                family = existing;
            }
        }
        return family;
    }

}
