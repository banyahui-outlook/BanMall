package com.aj.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class UserBlockHandler {
    public static String AllHandlerExpection(BlockException exception) {
        return "user block HandlerExpection :" + exception;
    }
}
