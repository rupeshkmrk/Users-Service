package com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.service;

import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.data.UserEntity;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.data.UserRepository;
import com.udemytutorial.photoapp.api.users.PhotoAppApiUsers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        //TODO : to be removed
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(String.valueOf(UUID.randomUUID()));
        userRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
        return returnValue;
    }
}
