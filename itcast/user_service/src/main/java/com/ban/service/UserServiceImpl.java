package com.ban.service;

import com.ban.entity.User;
import com.ban.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User getByName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public User login(String name) {
        return baseMapper.login(name);
    }
}
