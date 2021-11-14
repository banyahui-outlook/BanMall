package com.aj.controller;

import com.aj.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @DubboReference
    private IUserService userService;

    @GetMapping("/buy")
    public String buy() {
        var user = userService.user();
        return "web invoke user: " + user;
    }
}
