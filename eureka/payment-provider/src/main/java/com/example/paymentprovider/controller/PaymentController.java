package com.example.paymentprovider.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.example.common.entities.CommonResult;
import com.example.common.entities.Payment;

/**
 * TODO
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> one(@PathVariable Long id) {
        log.info("获取payment模块 端口: {}", port);
        return new CommonResult<>(200, "获取成功", new Payment(id, port));
    }

    @GetMapping("/payment/feign/timeout")
    public String feignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return port;
    }

}
