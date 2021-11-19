package com.ban.client;

import com.ban.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("order-service")
@RequestMapping("/order")
public interface IOrderServiceClient {
    @GetMapping("")
    String index();

    @GetMapping("/{id}")
    Order getOrder(@PathVariable(value = "id") Long id);
}
