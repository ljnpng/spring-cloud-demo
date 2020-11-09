package com.ljnpng.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * TODO
 */
@SpringBootApplication
@EnableFeignClients
public class OrderConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerFeignApplication.class, args);
    }

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

}
