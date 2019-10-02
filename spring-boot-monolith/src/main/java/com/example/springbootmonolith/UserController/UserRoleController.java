package com.example.springbootmonolith.UserController;

import com.example.springbootmonolith.models.UserRole;
import com.example.springbootmonolith.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    UserRoleService roleService;

    @GetMapping("/{roleName}")
    public UserRole getRole(@PathVariable String name) {
        return roleService.getRole(name);
    }

    @PostMapping
    public UserRole createRole(@RequestBody UserRole role) {
        return roleService.createRole(role);
    }

}