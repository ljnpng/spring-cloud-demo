package com.ljnpng.springcloud.controller;

import com.ljnpng.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//@DefaultProperties(defaultFallback = "paymentInfoTimeoutHandler1")
public class OrderController {

    private final PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable String id) {
        return paymentFeignService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler1",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfoTimeout(@PathVariable Integer id) {
        return paymentFeignService.paymentInfoTimeout(id);
    }

    public String paymentInfoTimeoutHandler1(@PathVariable Integer id) {
        return "order 客户端访问接口降级";
    }
}
