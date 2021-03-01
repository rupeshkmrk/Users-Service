package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.service;

import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;

import java.util.UUID;

public class UserServiceImpl implements UserService{

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(String.valueOf(UUID.randomUUID()));
        return null;
    }
}
