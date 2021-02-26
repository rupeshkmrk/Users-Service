package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @RequestMapping("/status/check")
    public String status() {
        return "Working";
    }
}
