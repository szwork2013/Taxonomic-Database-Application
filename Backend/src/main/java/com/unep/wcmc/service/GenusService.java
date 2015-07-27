package com.unep.wcmc.service;

import com.unep.wcmc.model.Genus;
import com.unep.wcmc.repository.GenusRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenusService extends AbstractService<Genus, GenusRepository> {

    public Genus findByName(String name) {
        return repo.findByName(name);
    }

    public Genus findOrSave(Genus genus) {
        if (genus != null) {
            Genus existing = repo.findByName(genus.getName());
            if (existing == null) {
                genus.setLastModified(new Date());
                genus = repo.save(genus);
            } else {
                genus = existing;
            }
        }
        return genus;
    }

}