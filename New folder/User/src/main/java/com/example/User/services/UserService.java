package com.example.User.services;


import com.example.User.models.User;
import com.example.User.repositories.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepositoty userRepositoty;

    @Autowired
    public UserService(UserRepositoty userRepositoty){
        this.userRepositoty = userRepositoty;
    }
    public List<User> getUsers(){
        return userRepositoty.findAll();
    }
    public User getUserId(Long id){
        User user = userRepositoty.findById(id).get();
        return user;
    }

}
