package com.ban.controller;

import com.ban.entity.User;
import com.ban.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User loginUser = userService.login("zhangsan");
        System.out.println(loginUser);
        return userService.getById(id);
    }
}
