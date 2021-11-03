package com.aj.service;

import com.aj.IGoodsService;
import com.aj.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements IUserService {
    @DubboReference
    private IGoodsService goodsService;

    @Override
    public String buy(String goodId, int count) {
        String test = goodsService.test();
        return "user buy good:" + goodId + ", result:" + test;
    }
}
