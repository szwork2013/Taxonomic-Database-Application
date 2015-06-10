package com.unep.wcmc.service;


import com.unep.wcmc.model.Family;
import com.unep.wcmc.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService implements BaseService<Family> {

    @Autowired
    FamilyRepository family;

    @Override
    public Family save(Family entity) {

        return family.save(entity);
    }

    @Override
    public Iterable<Family> list() {

        return (List<Family>) family.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        family.delete(id);

        return true;
    }

    @Override
    public Family get(Long id) {

        return family.findOne(id);
    }
}
