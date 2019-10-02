package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User getUser(String username);

    public Iterable<User> listUsers();

    public String createUser(User newUser);

    public HttpStatus deleteById(int userId);

    public User addSong(String title, int songId);

    public String login(User user);

}