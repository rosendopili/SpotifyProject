package com.example.springbootmonolith.repository;

import com.example.springbootmonolith.models.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    public UserRole findByName(String name);
}