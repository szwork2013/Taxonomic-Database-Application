package com.unep.wcmc.service;

import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.repository.PhylumRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public final class PhylumService extends AbstractService<Phylum, PhylumRepository> {

    public Phylum findByName(String name) {
        return repo.findByName(name);
    }

    public Phylum findOrSave(Phylum phylum) {
        if (phylum != null) {
            Phylum existing = repo.findByName(phylum.getName());
            if (existing == null) {
                phylum.setLastModified(new Date());
                phylum = repo.save(phylum);
            } else {
                phylum = existing;
            }
        }
        return phylum;
    }

}
