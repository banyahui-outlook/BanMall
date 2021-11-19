package com.aj.service;

import com.aj.IGoodsService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class GoodsServiceImpl implements IGoodsService {
    @Override
    public String goods() {
        return "good service success!";
    }
}
