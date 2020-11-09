package com.example.ordercomsume.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 */
@Configuration
public class RiboonRuleConfig {

    @Bean
    public IRule randomRule() {
        return new RoundRobinRule();
    }
}
