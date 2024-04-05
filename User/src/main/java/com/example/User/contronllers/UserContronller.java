package com.example.User.contronllers;


import com.example.User.models.User;
import com.example.User.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class UserContronller {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<User> getAll(){
            return  userService.getUsers();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable long id){
        return userService.getUserId(id);
    }
}
