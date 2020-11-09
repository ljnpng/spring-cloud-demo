package com.ljnpng.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * TODO
 */
@Component
public class PaymentFeignFallbackService implements PaymentFeignService {
    @Override
    public String paymentInfoOk(String id) {
        return "-- paymentInfoOk fallback";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-- paymentInfoTimeout fallback";
    }
}
