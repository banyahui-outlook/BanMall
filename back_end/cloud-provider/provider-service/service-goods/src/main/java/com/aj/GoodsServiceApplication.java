package com.aj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoodsServiceApplication implements ApplicationRunner {
    @Value("${app.version}")
    private String version;

    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args)  {
        System.out.println("goods remote config version:" + version);
    }
}
