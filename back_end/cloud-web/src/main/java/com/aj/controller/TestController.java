package com.aj.controller;

import com.aj.IUserService;
import com.aj.handler.SentinelHandlersClass;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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

    @GetMapping("/a")
    @SentinelResource(value="a", blockHandlerClass = SentinelHandlersClass.class, blockHandler = "limitBlockHandler")
    public String limit() {
        return "ok";
    }
    public String limitBlockHandler(BlockException be) {
        return "block a........";
    }
}
