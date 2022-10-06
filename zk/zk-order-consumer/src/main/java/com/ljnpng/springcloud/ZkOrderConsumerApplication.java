package com.ljnpng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ZkOrderConsumerApplication
 * @Description TODO
 * @Author liaojp
 * @Date 2022/10/6 13:13
 */
//@SpringCloudApplication //里面已经含有下面两个注解
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
