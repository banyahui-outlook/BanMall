package com.ban.controller;

import com.ban.client.IOrderServiceClient;
import com.ban.client.IUserServiceClient;
import com.ban.entity.Order;
import com.ban.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class OrderController implements IOrderServiceClient {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserServiceClient userServiceClient;

    //    @Autowired
    ////    private RestTemplate restTemplate;
    ////
    ////    @GetMapping("/{id}")
    ////    public Order getOrder(@PathVariable Long id) {
    ////        var order = orderService.getById(id);
    ////        var user = restTemplate.getForEntity("http://user-service/user/1", User.class);
    ////        order.setUser(user.getBody());
    ////        return order;
    ////    }

    @Value("${app.name}")
    private String appName;

    @Override
    public String index() {
        return appName;
    }

    @Override
    public Order getOrder(@PathVariable Long id) {
        var order = orderService.getById(id);
        var user = userServiceClient.getUserById(order.getUserId());
        order.setUser(user);
        return order;
    }
}
