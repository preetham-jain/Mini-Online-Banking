package com.example.Mini.Online.Banking.services.impl;

import com.example.Mini.Online.Banking.dto.LoginRequestDto;
import com.example.Mini.Online.Banking.dto.LoginResponseDto;
import com.example.Mini.Online.Banking.dto.UserRequestDto;
import com.example.Mini.Online.Banking.dto.UserResponseDto;
import com.example.Mini.Online.Banking.entity.Users;
import com.example.Mini.Online.Banking.repository.UserRepository;
import com.example.Mini.Online.Banking.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        Users users = new Users();
        UserResponseDto responseDto = new UserResponseDto();
        List<String> emailList=userRepository.getAllUsersByEmail();
        if(emailList.contains(userRequestDto.getEmail()))
        {
            responseDto.setMessage("Email already Exists");
        }
        //copy fields from dto to employee
        else {
            BeanUtils.copyProperties(userRequestDto, users);

            String hashedpassword = DigestUtils.sha256Hex(userRequestDto.getPassword());

            users.setPassword(hashedpassword);

//            Login login = new Login();

//            login.setEmail(users.getEmail());
//            login.setPassword(hashedpassword);

            //save employee to db
            Users savedUsers = userRepository.save(users);
//            loginRepository.save(login);

            // copy from employee to response dto

            //BeanUtils.copyProperties(savedUsers, responseDto);
            responseDto.setMessage("Registration Successful");
        }



        return responseDto;
    }


    @Override
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto)
    {
        Users user = userRepository.findByEmail(loginRequestDto.getEmail());
        LoginResponseDto responseDto = new LoginResponseDto();
        if(user != null) {
            String hashedpassword = DigestUtils.sha256Hex(loginRequestDto.getPassword());
            if( hashedpassword.equals(user.getPassword())) {

                responseDto.setId(user.getUser_id());
                responseDto.setMessage("Success");
            }
            else {
                responseDto.setId(null);
                responseDto.setMessage("Incorrect password");
            }
        }
        else {
            responseDto.setMessage("User does not exist");
            responseDto.setId(null);
        }
//        Optional<Login> optional = loginRepository.findById(loginRequestDto.getEmail());
//        if(optional.isPresent()){
//            String hashedpassword = DigestUtils.sha256Hex(loginRequestDto.getPassword());
//            System.out.println(hashedpassword);
//            return (optional.get().getPassword().equals(hashedpassword));
//        }
//        return false;
        return responseDto;
    }












}
