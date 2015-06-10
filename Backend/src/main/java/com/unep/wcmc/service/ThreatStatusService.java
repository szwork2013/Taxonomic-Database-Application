package com.unep.wcmc.service;


import com.unep.wcmc.model.ThreatStatus;
import com.unep.wcmc.repository.ThreatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreatStatusService implements BaseService<ThreatStatus> {

    @Autowired
    ThreatStatusRepository threatstatus;

    @Override
    public ThreatStatus save(ThreatStatus entity) {

        return threatstatus.save(entity);
    }

    @Override
    public Iterable<ThreatStatus> list() {

        return (List<ThreatStatus>) threatstatus.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        threatstatus.delete(id);

        return true;
    }

    @Override
    public ThreatStatus get(Long id) {

        return threatstatus.findOne(id);
    }
}
