package com.unep.wcmc.service;

import com.unep.wcmc.model.Family;
import com.unep.wcmc.repository.FamilyRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public final class FamilyService extends AbstractService<Family, FamilyRepository> {

    public Family findByName(String name) {
        return repo.findByName(name);
    }

    public Family findOrSave(Family family) {
        if (family != null) {
            Family existing = repo.findByName(family.getName());
            if (existing == null) {
                family.setLastModified(new Date());
                family = repo.save(family);
            } else {
                family = existing;
            }
        }
        return family;
    }

}
