package com.unep.wcmc.service;


import com.unep.wcmc.model.Threats;
import com.unep.wcmc.repository.ThreatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreatsService implements BaseService<Threats> {

    @Autowired
    ThreatsRepository threats;

    @Override
    public Threats save(Threats entity) {

        return threats.save(entity);
    }

    @Override
    public Iterable<Threats> list() {

        return (List<Threats>) threats.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        threats.delete(id);

        return true;
    }

    @Override
    public Threats get(Long id) {

        return threats.findOne(id);
    }
}
