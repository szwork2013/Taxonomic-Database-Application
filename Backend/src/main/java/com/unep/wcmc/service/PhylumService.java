package com.unep.wcmc.service;

import com.unep.wcmc.model.Phylum;
import com.unep.wcmc.repository.PhylumRepository;
import org.springframework.stereotype.Service;

@Service
public final class PhylumService extends AbstractService<Phylum, PhylumRepository> {

    public Phylum findOrSave(String name) {
        Phylum phylum = repo.findByName(name);
        if (phylum == null) {
            phylum = new Phylum(name);
            phylum = repo.save(phylum);
        }
        return phylum;
    }

}
