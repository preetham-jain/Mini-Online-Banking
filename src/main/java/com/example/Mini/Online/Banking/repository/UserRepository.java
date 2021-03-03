package com.example.Mini.Online.Banking.repository;

import com.example.Mini.Online.Banking.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,Long> {


    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Users findByEmail(String email);


    @Query(value="SELECT email FROM users",nativeQuery = true)
    List<String> getAllUsersByEmail();




}
