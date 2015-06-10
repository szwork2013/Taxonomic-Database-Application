package com.unep.wcmc.service;


import com.unep.wcmc.model.FeedingBehavior;
import com.unep.wcmc.repository.FeedingBehaviorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingBehaviorService implements BaseService<FeedingBehavior> {

    @Autowired
    FeedingBehaviorRepository feedingbehavior;

    @Override
    public FeedingBehavior save(FeedingBehavior entity) {

        return feedingbehavior.save(entity);
    }

    @Override
    public Iterable<FeedingBehavior> list() {

        return (List<FeedingBehavior>) feedingbehavior.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        feedingbehavior.delete(id);

        return true;
    }

    @Override
    public FeedingBehavior get(Long id) {

        return feedingbehavior.findOne(id);
    }
}
