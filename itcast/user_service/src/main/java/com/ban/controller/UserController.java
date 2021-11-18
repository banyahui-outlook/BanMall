package com.ban.controller;

import com.ban.client.IUserServiceClient;
import com.ban.entity.User;
import com.ban.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController implements IUserServiceClient {
    @Autowired
    private IUserService userService;

    @Value("${app.name}")
    private String appName;

    @Override
    public String index() {
        return appName;
    }
    @Override
    public User getUserById(@PathVariable(value = "id") Long id) {
        User user = userService.getById(id);
        log.info("user:" + id + " getUserById result:" + user);
        return user;
    }
    @Override
    public User getUserByName(@PathVariable(value = "name") String name) {
        User user = userService.getByName(name);
        log.info("user:" + name + " getUserByName result:" + user);
        return user;
    }
    @Override
    public User login(String name) {
        User user = userService.login(name);
        log.info("user:" + name + " login result:" + user);
        return user;
    }
}
