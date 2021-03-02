package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.service;

import com.netflix.discovery.converters.Auto;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.data.UserEntity;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.data.UserRepository;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDto createUser(UserDto userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        userEntity.setEncryptedPassword(passwordEncoder.encode(userDetails.getPassword()));
        userEntity.setUserId(String.valueOf(UUID.randomUUID()));
        userRepository.save(userEntity);

        return modelMapper.map(userEntity, UserDto.class);
    }
}
