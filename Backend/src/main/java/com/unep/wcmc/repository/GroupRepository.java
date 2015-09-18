package com.unep.wcmc.repository;

import com.unep.wcmc.model.Group;
import com.unep.wcmc.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

     Page<Group> findAllByUser(User user, Pageable pageable);
}
