package com.ljnpng.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Classname OrderController
 * @Description TODO
 * @Author liaojp
 * @Date 2022/10/6 13:17
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {
    private static final String INVOLK_URL = "http://zk-payment-provider/";

    private static final String CONSUME_URL = INVOLK_URL + "payment/zk/test";

    private final RestTemplate restTemplate;

    @GetMapping("/order/consume/zk")
    public String consume() {
        return restTemplate.getForObject(CONSUME_URL, String.class);
    }
}
