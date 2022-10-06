package com.example.ordercomsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.lb.RibbonRuleConfig;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PAYMENT-PROVIDER", configuration = RibbonRuleConfig.class)
public class RibbonOrderConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonOrderConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
