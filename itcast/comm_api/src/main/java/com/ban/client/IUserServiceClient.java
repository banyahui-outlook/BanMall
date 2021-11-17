package com.ban.client;

import com.ban.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
@RequestMapping("/user")
public interface IUserServiceClient {
    @GetMapping("/{id}")
    User getUser(@PathVariable(value = "id") Long id);
}
