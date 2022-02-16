package org.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    // 配置Ribbon的负载均衡策略
    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
