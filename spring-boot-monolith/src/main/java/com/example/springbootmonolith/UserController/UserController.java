package com.example.springbootmonolith.UserController;
import com.example.springbootmonolith.models.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public UserResponse Test(@RequestBody UserResponse inputPayload) {
        UserResponse response = new UserResponse();
        response.setUserName(inputPayload.getUserName());
        response.setResponse("Hello " + inputPayload.getUserName());
        return response;
    }

}