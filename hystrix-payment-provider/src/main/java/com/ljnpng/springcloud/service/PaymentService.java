package com.ljnpng.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 */
@Service
public class PaymentService {

    public String paymentInfoOk(String id) {
        return "线程：" + Thread.currentThread().getName() + " paymentInfoOk " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfoTimeout(Integer id) {
//        try{
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int age = 1/0;
        return "线程：" + Thread.currentThread().getName() + " paymentInfoTimeout " + id;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程：" + Thread.currentThread().getName() + " 系统繁忙，请稍后再试 " + id;
    }
}
