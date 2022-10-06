package com.example.ordercomsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import com.example.common.entities.CommonResult;
import com.example.common.entities.Payment;

/**
 * 不通过注册中心，直接通过rest调用指定服务
 */
@RestController
@Slf4j
public class OriginalRestController {

    public static final String PAYMENT_URL = "http://localhost:8001/";

    @Autowired
    @Qualifier("restOriginalTemplate")
    private RestTemplate restOriginalTemplate;

    @GetMapping("/consume/{id}")
    public CommonResult<Payment> id(@PathVariable Long id) {
        log.warn("配置完负载均衡之后这个resttemplate已经不能能够识别localhost了");
        return restOriginalTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
    }


}
