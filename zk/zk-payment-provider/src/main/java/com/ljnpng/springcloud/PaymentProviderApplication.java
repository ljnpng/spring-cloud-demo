package com.ljnpng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentProviderApplication.class, args);
    }
}
