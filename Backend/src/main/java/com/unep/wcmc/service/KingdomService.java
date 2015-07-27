package com.unep.wcmc.service;

import com.unep.wcmc.model.Kingdom;
import com.unep.wcmc.repository.KingdomRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KingdomService extends AbstractService<Kingdom, KingdomRepository> {

    public Kingdom findByName(String name) {
        return repo.findByName(name);
    }

    public Kingdom findOrSave(Kingdom kingdom) {
        if (kingdom != null) {
            Kingdom existing = repo.findByName(kingdom.getName());
            if (existing == null) {
                kingdom.setLastModified(new Date());
                kingdom = repo.save(kingdom);
            } else {
                kingdom = existing;
            }
        }
        return kingdom;
    }

}