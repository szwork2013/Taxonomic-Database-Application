package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Genus;
import com.unep.wcmc.repository.GenusRepository;

@Service
public class GenusService extends AbstractService<Genus, GenusRepository> {

    public Genus findOrSave(Genus genus) {
        if (genus != null) {
            Genus existing = repo.findByName(genus.getName());
            if (existing == null) {
                genus = repo.save(genus);
            } else {
                genus = existing;
            }
        }
        return genus;
    }

}