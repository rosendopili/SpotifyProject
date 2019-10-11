package com.example.springbootmonolith.Controller;

import com.example.springbootmonolith.models.JwtResponse;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/list")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }

    /*Internal server error when running tests on signup for postman*/
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser){
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    @PutMapping("/user/{username}/{songId}")
    public User addSong(@PathVariable String title, @PathVariable int songId){
        return userService.addSong(title, songId);
    }

    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable int userId) {
        return userService.deleteById(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }


}
