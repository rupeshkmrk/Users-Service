package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.ui.controller;

import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.ui.model.CreateUserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment environment;

    @RequestMapping("/status/check")
    public String status() {
        return "User service running on port " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@RequestBody @Valid CreateUserRequestModel userRequestModel) {
        return "create user called";
    }
}
