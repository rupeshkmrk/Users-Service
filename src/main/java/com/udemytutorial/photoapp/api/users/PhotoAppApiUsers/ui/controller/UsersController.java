package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.ui.controller;

import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.service.UserService;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.ui.model.CreateUserRequestModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/status/check")
    public String status() {
        return "User service running on port " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid CreateUserRequestModel userRequestModel) {
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(userRequestModel, UserDto.class);
        userService.createUser(userDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
