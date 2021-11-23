package com.ban;

import com.ban.entity.Hotel;
import com.ban.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticSearchApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    @Autowired
    private IHotelService hotelService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Hotel hotel = hotelService.getById(36934L);
        System.out.println(hotel);
    }
}
