package com.example.storage.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StorageProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageProviderApplication.class, args);
    }

}
