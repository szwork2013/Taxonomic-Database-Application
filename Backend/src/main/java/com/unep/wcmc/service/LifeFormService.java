package com.unep.wcmc.service;


import com.unep.wcmc.model.LifeForm;
import com.unep.wcmc.repository.LifeFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LifeFormService implements BaseService<LifeForm> {

    @Autowired
    LifeFormRepository lifeform;

    @Override
    public LifeForm save(LifeForm entity) {

        return lifeform.save(entity);
    }

    @Override
    public Iterable<LifeForm> list() {

        return (List<LifeForm>) lifeform.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        lifeform.delete(id);

        return true;
    }

    @Override
    public LifeForm get(Long id) {

        return lifeform.findOne(id);
    }
}
