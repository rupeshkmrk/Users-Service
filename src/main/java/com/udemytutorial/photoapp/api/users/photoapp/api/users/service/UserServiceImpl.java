package com.udemytutorial.photoapp.api.users.photoapp.api.users.service;

import com.udemytutorial.photoapp.api.users.photoapp.api.users.data.UserEntity;
import com.udemytutorial.photoapp.api.users.photoapp.api.users.data.UserRepository;
import com.udemytutorial.photoapp.api.users.photoapp.api.users.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public UserDto getUserDetails(String email) {
        var userDetails = userRepository.findByEmail(email);
        if (null == userDetails) throw new UsernameNotFoundException("Invalid Email");
        return new ModelMapper().map(userDetails, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);
        if (null == user) throw new UsernameNotFoundException("Invalid email");
        return new User(username, user.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }
}
