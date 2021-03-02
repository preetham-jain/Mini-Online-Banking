package com.example.Mini.Online.Banking.services.impl;

import com.example.Mini.Online.Banking.dto.UserRequestDto;
import com.example.Mini.Online.Banking.dto.UserResponseDto;
import com.example.Mini.Online.Banking.entity.Users;
import com.example.Mini.Online.Banking.repository.UserRepository;
import com.example.Mini.Online.Banking.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        Users users = new Users();

        //copy fields from dto to employee
        BeanUtils.copyProperties(userRequestDto, users);

        //save employee to db
        Users savedUsers = userRepository.save(users);

        // copy from employee to response dto
        UserResponseDto responseDto = new UserResponseDto();
        BeanUtils.copyProperties(savedUsers, responseDto);


        return responseDto;
    }









}
