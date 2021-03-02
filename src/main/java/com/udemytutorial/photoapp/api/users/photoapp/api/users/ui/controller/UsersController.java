package com.udemytutorial.photoapp.api.users.photoapp.api.users.ui.controller;

import com.udemytutorial.photoapp.api.users.photoapp.api.users.service.UserService;
import com.udemytutorial.photoapp.api.users.photoapp.api.users.shared.UserDto;
import com.udemytutorial.photoapp.api.users.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.udemytutorial.photoapp.api.users.photoapp.api.users.ui.model.CreateUserResponseModel;
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
import javax.ws.rs.core.MediaType;

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

    @PostMapping/*(
            consumes = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}
    )*/
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody @Valid CreateUserRequestModel userRequestModel) {
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(userRequestModel, UserDto.class);
        UserDto createdUser = userService.createUser(userDto);

        CreateUserResponseModel responseModel = mapper.map(createdUser, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }
}
