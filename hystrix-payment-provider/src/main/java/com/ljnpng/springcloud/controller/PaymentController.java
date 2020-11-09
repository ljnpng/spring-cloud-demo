package com.ljnpng.springcloud.controller;

import com.ljnpng.springcloud.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable String id) {
        log.info("/payment/hystrix/ok/{}", id);
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable Integer id) {
        log.info("/payment/hystrix/timeout/{}", id);
        return paymentService.paymentInfoTimeout(id);
    }
}
