package com.unep.wcmc.service;

import com.unep.wcmc.model.IntegrationSource;
import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.repository.IntegrationSourceRepository;
import com.unep.wcmc.repository.PhylumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class PhylumService extends AbstractService<Phylum, PhylumRepository> {

    @Autowired
    private IntegrationSourceRepository integrationRepo;

    public Phylum findOrSave(Phylum phylum) {
        if (phylum != null) {
            Phylum existing = repo.findByName(phylum.getName());
            if (existing == null) {
                if (phylum.getIntegrationSource() != null) {
                    IntegrationSource integration =
                            integrationRepo.findBySource(phylum.getIntegrationSource().getSource());
                    phylum.setIntegrationSource(integration);
                }
                phylum = repo.save(phylum);
            } else {
                phylum = existing;
            }
        }
        return phylum;
    }

}
