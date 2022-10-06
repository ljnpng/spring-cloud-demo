package com.example.ordercomsume.controller;

import com.example.common.entities.CommonResult;
import com.example.common.entities.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * TODO
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL = "http://localhost:8001/";

    public static final String PAYMENT_SERVER = "http://PAYMENT-PROVIDER/";

    @GetMapping("/consume/payment/rest/{id}")
    public CommonResult<Payment> one(@PathVariable Long id) {
        log.info("配置完负载均衡之后这个resttemplate已经不能能够识别localhost了");
        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
    }

    @GetMapping("/consume/payment/eureka/{id}")
    public CommonResult<Payment> oneByEureka(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SERVER + "payment/" + id, CommonResult.class);
    }

    @GetMapping("/consume/discover")
    public String discover() {
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> {
            log.info("discover service:  {}", s);
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            instances.forEach(serviceInstance -> log.info("discover instance: {}", serviceInstance));
        });
        return services.toString();
    }
}
