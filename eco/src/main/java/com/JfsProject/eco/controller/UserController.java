package com.JfsProject.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JfsProject.eco.dto.Logindto;
import com.JfsProject.eco.dto.Registerdto;
import com.JfsProject.eco.dto.UpdateProfiledto;
import com.JfsProject.eco.dto.UserProfiledto;
import com.JfsProject.eco.model.User;
import com.JfsProject.eco.service.UserService;


@RestController
@RequestMapping("/api/user")

public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody Registerdto registerdto) {
        return userService.register(registerdto);
    }

    @PostMapping("/login")
    public User login(@RequestBody Logindto logindto) {
        return userService.login(logindto);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping("/profile/{userId}")
    public UserProfiledto getProfile(@PathVariable Long userId){

        return userService.getProfile(userId);

    }
    
    @PutMapping("/profile/{userId}")
    public User updateProfile(@PathVariable Long userId,
                              @RequestBody UpdateProfiledto dto){

        return userService.updateProfile(userId, dto);

    }

}
