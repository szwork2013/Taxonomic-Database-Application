package com.unep.wcmc.service;


import com.unep.wcmc.model.DensityData;
import com.unep.wcmc.repository.DensityDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DensityDataService implements BaseService<DensityData> {

    @Autowired
    DensityDataRepository densitydata;

    @Override
    public DensityData save(DensityData entity) {

        return densitydata.save(entity);
    }

    @Override
    public Iterable<DensityData> list() {

        return (List<DensityData>) densitydata.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        densitydata.delete(id);

        return true;
    }

    @Override
    public DensityData get(Long id) {

        return densitydata.findOne(id);
    }
}
