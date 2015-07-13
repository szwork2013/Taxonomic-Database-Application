package com.unep.wcmc.service;

import com.unep.wcmc.model.Kingdom;
import com.unep.wcmc.repository.KingdomRepository;
import org.springframework.stereotype.Service;

@Service
public class KingdomService extends AbstractService<Kingdom, KingdomRepository> {

    public Kingdom findOrSave(String name) {
        Kingdom kingdom = repo.findByName(name);
        if (kingdom == null) {
            kingdom = new Kingdom(name);
            kingdom = repo.save(kingdom);
        }
        return kingdom;
    }

}