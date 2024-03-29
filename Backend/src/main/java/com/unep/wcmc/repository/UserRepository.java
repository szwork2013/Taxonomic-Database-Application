package com.unep.wcmc.repository;

import com.unep.wcmc.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    Page<User> findByFirstNameContaining(String firstName, Pageable pageable);

    List<User> findByUserRoleRole(String role);
}
