package com.example.ordercomsume.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname DiscoverController
 * @Description TODO
 * @Author liaojp
 * @Date 2022/10/6 15:41
 */
@RestController
public class DiscoverController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/order/discovery")
    public List<ServiceInstance> discovery() {
        return discoveryClient.getServices().stream().map(s -> discoveryClient.getInstances(s)).flatMap(Collection::stream).collect(Collectors.toList());
    }
}
