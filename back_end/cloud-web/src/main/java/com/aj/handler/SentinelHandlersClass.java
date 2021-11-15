package com.aj.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelHandlersClass {
    public static String limitBlockHandler(BlockException be) {
        return "block a1........";
    }
}
