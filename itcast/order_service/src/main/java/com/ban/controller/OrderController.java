package com.ban.controller;

import com.ban.entity.Order;
import com.ban.entity.User;
import com.ban.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        var order = orderService.getById(id);
        var user = restTemplate.getForEntity("http://user-service/user/1", User.class);
        order.setUser(user.getBody());
        return order;
    }
}
