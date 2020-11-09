package com.ljnpng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentProviderApplication.class, args);
    }
}
