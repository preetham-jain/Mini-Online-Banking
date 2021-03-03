package com.example.Mini.Online.Banking.services.impl;

import com.example.Mini.Online.Banking.dto.LoginRequestDto;
import com.example.Mini.Online.Banking.dto.LoginResponseDto;
import com.example.Mini.Online.Banking.dto.UserRequestDto;
import com.example.Mini.Online.Banking.dto.UserResponseDto;
import com.example.Mini.Online.Banking.entity.Login;
import com.example.Mini.Online.Banking.entity.Users;
import com.example.Mini.Online.Banking.repository.LoginRepository;
import com.example.Mini.Online.Banking.repository.UserRepository;
import com.example.Mini.Online.Banking.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        Users users = new Users();

        //copy fields from dto to employee
        BeanUtils.copyProperties(userRequestDto, users);

        String hashedpassword = DigestUtils.sha256Hex(userRequestDto.getPassword());

        users.setPassword(hashedpassword);

        Login login = new Login();

        login.setEmail(users.getEmail());
        login.setPassword(hashedpassword);

        //save employee to db
        Users savedUsers = userRepository.save(users);
        loginRepository.save(login);

        // copy from employee to response dto
        UserResponseDto responseDto = new UserResponseDto();
        BeanUtils.copyProperties(savedUsers, responseDto);


        return responseDto;
    }


    @Override
    public boolean loginUser(LoginRequestDto loginRequestDto)
    {

        Optional<Login> optional = loginRepository.findById(loginRequestDto.getEmail());
        if(optional.isPresent()){
            String hashedpassword = DigestUtils.sha256Hex(loginRequestDto.getPassword());
            System.out.println(hashedpassword);
            return (optional.get().getPassword().equals(hashedpassword));
        }
        return false;
    }










}
