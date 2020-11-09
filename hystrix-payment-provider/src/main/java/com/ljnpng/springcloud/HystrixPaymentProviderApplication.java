package com.ljnpng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker /*服务熔断*/
public class HystrixPaymentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentProviderApplication.class, args);
    }
}
