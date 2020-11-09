package com.ljnpng.springcloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    public final RestTemplate restTemplate;


    public static final String INVOKE_URL = "http://consul-payment-provider/";

    @GetMapping("/consumer/order/consul")
    public String test() {
        return restTemplate.getForObject(INVOKE_URL + "payment/consul/test", String.class);
    }
}
