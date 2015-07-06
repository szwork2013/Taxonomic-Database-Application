package com.unep.wcmc.repository;

import org.springframework.data.repository.CrudRepository;

import com.unep.wcmc.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    
    UserRole findByRole(String role);
    UserRole findByName(String name);
}
