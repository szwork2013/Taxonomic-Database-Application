package com.unep.wcmc.service;


import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.repository.DistributionAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionAreaService implements BaseService<DistributionArea> {

    @Autowired
    DistributionAreaRepository distributionarea;

    @Override
    public DistributionArea save(DistributionArea entity) {

        return distributionarea.save(entity);
    }

    @Override
    public Iterable<DistributionArea> list() {

        return (List<DistributionArea>) distributionarea.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        distributionarea.delete(id);

        return true;
    }

    @Override
    public DistributionArea get(Long id) {

        return distributionarea.findOne(id);
    }
}
