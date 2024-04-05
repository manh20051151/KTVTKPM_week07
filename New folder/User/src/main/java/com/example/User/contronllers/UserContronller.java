package com.example.User.contronllers;


import com.example.User.models.User;
import com.example.User.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserContronller {
    @Autowired
    private UserService userService;

    @GetMapping("/Users")
    List<User> getAll(){
            return  userService.getUsers();
    }
}
