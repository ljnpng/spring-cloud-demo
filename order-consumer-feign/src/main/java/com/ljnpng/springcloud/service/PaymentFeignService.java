package com.ljnpng.springcloud.service;

import com.example.common.entities.CommonResult;
import com.example.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 */
@FeignClient("PAYMENT-PROVIDER")
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    CommonResult<Payment> one(@PathVariable Long id);

    @GetMapping("/payment/feign/timeout")
    String feignTimeOut();
}
