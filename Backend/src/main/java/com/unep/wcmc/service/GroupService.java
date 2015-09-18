package com.unep.wcmc.service;

import com.unep.wcmc.model.Group;
import com.unep.wcmc.model.User;
import com.unep.wcmc.repository.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends AbstractService<Group, GroupRepository> {

    public Page<Group> findAllByUser(User user, Pageable pageable){
        return repo.findAllByUser(user, pageable);
    }
}
