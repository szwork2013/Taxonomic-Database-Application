package com.unep.wcmc.service;


import com.unep.wcmc.model.ExtinctionRisk;
import com.unep.wcmc.repository.ExtinctionRiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtinctionRiskService implements BaseService<ExtinctionRisk> {

    @Autowired
    ExtinctionRiskRepository extinctionrisk;

    @Override
    public ExtinctionRisk save(ExtinctionRisk entity) {

        return extinctionrisk.save(entity);
    }

    @Override
    public Iterable<ExtinctionRisk> list() {

        return (List<ExtinctionRisk>) extinctionrisk.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        extinctionrisk.delete(id);

        return true;
    }

    @Override
    public ExtinctionRisk get(Long id) {

        return extinctionrisk.findOne(id);
    }
}
