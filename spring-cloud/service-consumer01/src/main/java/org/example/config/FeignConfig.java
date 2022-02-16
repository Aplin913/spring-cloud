package org.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    // 配置Openfeign的日志打印级别
    @Bean
    public Logger.Level getLoggerLevel(){
        return Logger.Level.FULL;
    }
}
