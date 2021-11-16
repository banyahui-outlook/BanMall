package com.ban.service;

import com.ban.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {
    User login(String name);
}
