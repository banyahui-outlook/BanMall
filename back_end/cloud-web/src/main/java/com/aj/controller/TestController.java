package com.aj.controller;

import com.aj.IUserService;
import com.aj.handler.TestService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//    @DubboReference
//    private IUserService userService;
//
//    @GetMapping("/buy")
//    public String buy() {
//        var user = userService.user();
//        return "web invoke user: " + user;
//    }


    @Autowired
    private TestService service;

    @GetMapping("/foo")
    public String apiFoo(@RequestParam(required = false) Long t) throws Exception {
        if (t == null) {
            t = System.currentTimeMillis();
        }
        service.test();
        return service.hello(t);
    }



    public String handlerFallback(BlockException e) {
        return "程序处理异常，开始执行fallback数据-->";
    }
}
