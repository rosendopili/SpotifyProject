package com.example.springbootmonolith.UserController;
import com.example.springbootmonolith.models.UserResponse;
import org.springframework.web.bind.annotation.*;
import com.example.springbootmonolith.models.SampleResponse;
import com.example.springbootmonolith.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }


    @GetMapping("/test")
    public UserResponse Test(@RequestBody UserResponse inputPayload) {
        UserResponse response = new UserResponse();
        response.setUserName(inputPayload.getUserName());
        response.setResponse("Hello " + inputPayload.getUserName());
        return response;
    }

}