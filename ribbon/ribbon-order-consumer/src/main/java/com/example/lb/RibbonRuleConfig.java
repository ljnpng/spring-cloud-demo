package com.example.lb;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 这个需要配置 autoscan之外，不然全都都会用统一个
 */
public class RibbonRuleConfig {

    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }
}
