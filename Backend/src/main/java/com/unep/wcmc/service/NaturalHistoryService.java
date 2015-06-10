package com.unep.wcmc.service;


import com.unep.wcmc.model.NaturalHistory;
import com.unep.wcmc.repository.NaturalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaturalHistoryService implements BaseService<NaturalHistory> {

    @Autowired
    NaturalHistoryRepository naturalhistory;

    @Override
    public NaturalHistory save(NaturalHistory entity) {

        return naturalhistory.save(entity);
    }

    @Override
    public Iterable<NaturalHistory> list() {

        return (List<NaturalHistory>) naturalhistory.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        naturalhistory.delete(id);

        return true;
    }

    @Override
    public NaturalHistory get(Long id) {

        return naturalhistory.findOne(id);
    }
}
