package com.ban.service.impl;

import com.ban.entity.Hotel;
import com.ban.mapper.HotelMapper;
import com.ban.service.IHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
}
