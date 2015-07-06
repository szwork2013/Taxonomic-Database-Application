package com.unep.wcmc.repository;

import org.springframework.data.repository.CrudRepository;

import com.unep.wcmc.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String username);
}
