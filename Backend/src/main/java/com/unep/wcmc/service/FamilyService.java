package com.unep.wcmc.service;

import com.unep.wcmc.model.Family;
import com.unep.wcmc.repository.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
public final class FamilyService extends AbstractService<Family, FamilyRepository> {

    public Family findOrSave(String name) {
        Family family = repo.findByName(name);
        if (family == null) {
            family = new Family(name);
            family = repo.save(family);
        }
        return family;
    }

}
