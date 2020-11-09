package com.ljnpng.springcloud.controller;

import com.example.common.entities.CommonResult;
import com.example.common.entities.Payment;
import com.ljnpng.springcloud.service.PaymentFeignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> one(@PathVariable Long id) {
        return paymentFeignService.one(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeout() {
        return paymentFeignService.feignTimeOut();
    }
}
