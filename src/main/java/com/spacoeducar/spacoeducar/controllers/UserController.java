package com.spacoeducar.spacoeducar.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    // @Autowired
    // private UserService userService;

    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public List<User> findAll() {
    //     return userService.findAll();
    // }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String findAll() {
        return "Hello, world!";
    }

    
}
