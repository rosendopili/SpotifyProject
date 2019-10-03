package com.example.springbootmonolith.repository;

import com.example.springbootmonolith.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("FROM User u WHERE u.username = ?1 and u.password = ?2")
    public User findByUsername(String username);

}