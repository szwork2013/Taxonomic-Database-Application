package com.unep.wcmc.service;

import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Kingdom;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.KingdomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdomService extends AbstractService<Kingdom, KingdomRepository> {

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public Kingdom findOrSave(Kingdom kingdom) {
        if (kingdom != null) {
            Kingdom existing = repo.findByName(kingdom.getName());
            if (existing == null) {
                if (kingdom.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(kingdom.getIntegrationSource().getSource());
                    kingdom.setIntegrationSource(integration);
                }
                kingdom = repo.save(kingdom);
            } else {
                kingdom = existing;
            }
        }
        return kingdom;
    }

}