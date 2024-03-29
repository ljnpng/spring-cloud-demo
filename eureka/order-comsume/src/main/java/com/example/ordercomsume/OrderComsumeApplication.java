package com.example.ordercomsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
//@RibbonClient(name = "PAYMENT-PROVIDER", configuration = RiboonRuleConfig.class)
public class OrderComsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderComsumeApplication.class, args);
    }

    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean("restOriginalTemplate")
    public RestTemplate getRestOriginalTemplate() {
        return new RestTemplate();
    }

}
