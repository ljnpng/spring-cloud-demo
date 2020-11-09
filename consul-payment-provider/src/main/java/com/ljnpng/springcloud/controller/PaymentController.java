package com.ljnpng.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * TODO
 */
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul/test")
    public String test() {
        log.info("获取payment模块 端口: {}", port);
        return "访问payment consul port = " + port + " " + UUID.randomUUID();
    }
}
