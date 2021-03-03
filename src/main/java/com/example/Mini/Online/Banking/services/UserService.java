package com.example.Mini.Online.Banking.services;

import com.example.Mini.Online.Banking.dto.LoginRequestDto;
import com.example.Mini.Online.Banking.dto.LoginResponseDto;
import com.example.Mini.Online.Banking.dto.UserRequestDto;
import com.example.Mini.Online.Banking.dto.UserResponseDto;

public interface UserService {

    UserResponseDto registerUser(UserRequestDto userRequestDto);

    boolean loginUser(LoginRequestDto loginRequestDto);
}
