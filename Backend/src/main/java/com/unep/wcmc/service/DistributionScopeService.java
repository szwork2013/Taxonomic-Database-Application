package com.unep.wcmc.service;


import com.unep.wcmc.model.DistributionScope;
import com.unep.wcmc.repository.DistributionScopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionScopeService implements BaseService<DistributionScope> {

    @Autowired
    DistributionScopeRepository distributionscope;

    @Override
    public DistributionScope save(DistributionScope entity) {

        return distributionscope.save(entity);
    }

    @Override
    public Iterable<DistributionScope> list() {

        return (List<DistributionScope>) distributionscope.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        distributionscope.delete(id);

        return true;
    }

    @Override
    public DistributionScope get(Long id) {

        return distributionscope.findOne(id);
    }
}
