package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment environment;

    @RequestMapping("/status/check")
    public String status() {
        return "User service running on port " + environment.getProperty("local.server.port");
    }
}
