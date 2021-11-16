package com.ban.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "`order`")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long goodsId;
    private Integer count;
    @TableField(exist = false)
    private User user;
}
