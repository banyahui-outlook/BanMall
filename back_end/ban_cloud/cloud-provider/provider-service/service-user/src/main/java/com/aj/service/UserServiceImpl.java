package com.aj.service;

import com.aj.IGoodsService;
import com.aj.IUserService;
import com.aj.handler.UserBlockHandler;
import com.aj.handler.UserFallbackHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements IUserService {
    @DubboReference
    private IGoodsService goodsService;

    @Override
    public String user() {
        String goods = goodsService.goods();
        return "user success, goods:" + goods;
    }
}
