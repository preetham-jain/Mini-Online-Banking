package com.example.Mini.Online.Banking.controller;

import com.example.Mini.Online.Banking.dto.LoginRequestDto;
import com.example.Mini.Online.Banking.dto.LoginResponseDto;
import com.example.Mini.Online.Banking.dto.UserRequestDto;
import com.example.Mini.Online.Banking.dto.UserResponseDto;
import com.example.Mini.Online.Banking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private  UserService userService;

    @PostMapping("/register")
    public UserResponseDto registerUser(@RequestBody UserRequestDto userRequestDto) {

        return userService.registerUser(userRequestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody LoginRequestDto loginRequestDto) {

        return userService.loginUser(loginRequestDto);
    }

















}
