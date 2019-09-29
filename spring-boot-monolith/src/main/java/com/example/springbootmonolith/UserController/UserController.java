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


    @GetMapping("/get")
    public SampleResponse get(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        SampleResponse response = new SampleResponse();
        response.setId((long) 1);
        response.setResponse("Your name is "+ name);
        return response;
    }

    @PostMapping("/post")
    public UserResponse post(@RequestBody UserResponse inputPayLoad) {
        UserResponse postResponse = new UserResponse();
        postResponse.setId(inputPayLoad.getId());
        postResponse.setResponse("Hello " + inputPayLoad.getId());
        return postResponse;
    }

}