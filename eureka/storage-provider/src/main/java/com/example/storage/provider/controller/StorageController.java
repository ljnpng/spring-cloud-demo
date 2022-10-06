package com.example.storage.provider.controller;

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
public class StorageController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/storage/{id}")
    public CommonResult<Payment> one(@PathVariable Long id) {
        log.info("获取storage模块 端口: {}", port);
        return new CommonResult<>(200, "获取成功", new Payment(id, port));
    }

}
