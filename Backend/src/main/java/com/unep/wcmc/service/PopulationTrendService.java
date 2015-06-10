package com.unep.wcmc.service;


import com.unep.wcmc.model.PopulationTrend;
import com.unep.wcmc.repository.PopulationTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationTrendService implements BaseService<PopulationTrend> {

    @Autowired
    PopulationTrendRepository populationtrend;

    @Override
    public PopulationTrend save(PopulationTrend entity) {

        return populationtrend.save(entity);
    }

    @Override
    public Iterable<PopulationTrend> list() {

        return (List<PopulationTrend>) populationtrend.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        populationtrend.delete(id);

        return true;
    }

    @Override
    public PopulationTrend get(Long id) {

        return populationtrend.findOne(id);
    }
}
