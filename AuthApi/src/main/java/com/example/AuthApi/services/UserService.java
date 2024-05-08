package com.example.AuthApi.services;

import com.example.AuthApi.dtos.UserDto;
import com.example.AuthApi.entities.UserEntity;
import com.example.AuthApi.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> listAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    public void insert(UserDto user) {
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }

    public UserDto update(UserDto user) {
        UserEntity userEntity = new UserEntity(user);
        return new UserDto(userRepository.save(userEntity));
    }

    public void delete(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public UserDto searchById(Long id) {
        return  new UserDto(userRepository.findById(id).get());
    }
}
