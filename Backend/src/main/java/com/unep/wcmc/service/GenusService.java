package com.unep.wcmc.service;

import org.springframework.stereotype.Service;

import com.unep.wcmc.model.Genus;
import com.unep.wcmc.repository.GenusRepository;

@Service
public class GenusService extends AbstractService<Genus, GenusRepository> {

    public Genus findOrSave(String name) {
        Genus genus = repo.findByName(name);
        if (genus == null) {
            genus = new Genus(name);
            genus = repo.save(genus);
        }
        return genus;
    }

}