package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.UserRole;
import com.example.springbootmonolith.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole createRole(UserRole newRole) {
        return userRoleRepository.save(newRole);
    }

    @Override
    public UserRole getRole(String name) {
        return userRoleRepository.findByName(name);
    }
}