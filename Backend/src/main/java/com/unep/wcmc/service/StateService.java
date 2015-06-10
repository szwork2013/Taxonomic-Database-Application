package com.unep.wcmc.service;


import com.unep.wcmc.model.State;
import com.unep.wcmc.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService implements BaseService<State> {

    @Autowired
    StateRepository state;

    @Override
    public State save(State entity) {

        return state.save(entity);
    }

    @Override
    public Iterable<State> list() {

        return (List<State>) state.findAll();
    }

    @Override
    public Boolean delete(Long id) {
        state.delete(id);

        return true;
    }

    @Override
    public State get(Long id) {

        return state.findOne(id);
    }
}
