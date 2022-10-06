package com.example.ordercomsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import com.example.common.entities.CommonResult;
import com.example.common.entities.Payment;


/**
 * TODO
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_SERVER = "http://PAYMENT-PROVIDER/";
    public static final String STORAGE_SERVER = "http://STORAGE-PROVIDER/";

    @GetMapping("/consume/payment/eureka/{id}")
    public CommonResult<Payment> oneByEureka(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SERVER + "payment/" + id, CommonResult.class);
    }

    @GetMapping("/consume/storage/eureka/{id}")
    public CommonResult<Payment> storage(@PathVariable Long id) {
        return restTemplate.getForObject(STORAGE_SERVER + "storage/" + id, CommonResult.class);
    }

}
