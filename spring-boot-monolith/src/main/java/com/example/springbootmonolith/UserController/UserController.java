package com.example.springbootmonolith.UserController;


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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user/list")
    public Iterable<User> listUsers(){
        return userService.listUsers();
    }
    @PostMapping("/signup")
    public String createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password){
        return userService.login(username, password);
    }

    @PutMapping("/user/{username}/{songId}")
    public User addSong(@PathVariable String username, @PathVariable int songId){
        return userService.addSong(username, songId);
    }

    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
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
