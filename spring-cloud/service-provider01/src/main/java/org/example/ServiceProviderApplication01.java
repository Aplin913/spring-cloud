package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "org.example.mapper")
@EnableCircuitBreaker // 启用断路器（使用Hystrix需要添加）
public class ServiceProviderApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication01.class, args);
    }
}
