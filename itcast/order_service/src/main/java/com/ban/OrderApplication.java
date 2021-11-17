package com.ban;

import com.ban.client.IUserServiceClient;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableFeignClients(clients = IUserServiceClient.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    //    @Bean
    //    @LoadBalanced
    //    public RestTemplate restTemplate() {
    //        return new RestTemplate();
    //    }

    @Bean
    public IRule getRule() {
        return new RandomRule();
    }

//    @Bean
//    public Logger.Level getLogger() {
//        return Logger.Level.FULL;
//    }
}
