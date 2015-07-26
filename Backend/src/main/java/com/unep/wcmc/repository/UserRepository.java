package com.unep.wcmc.repository;

import com.unep.wcmc.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    Page<User> findByNameContaining(String name, Pageable pageable);
}
