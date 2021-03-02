package com.udemytutorial.photoapp.api.users.photoapp.api.users.service;

import com.udemytutorial.photoapp.api.users.photoapp.api.users.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);
}
