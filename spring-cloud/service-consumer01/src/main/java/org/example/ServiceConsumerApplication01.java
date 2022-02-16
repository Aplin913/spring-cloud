package org.example;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.example.config.FeignConfig;
import org.example.config.RibbonConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


/**
 * @description 服务消费者
 * @author ShuLin
 * @date 2022-02-16 09:29
 * 使用OpenFeign进行远程调用，并使用Ribbon进行负载均衡
 */
@SpringBootApplication
@EnableEurekaClient // 只能用于Eureka注册中心
// @EnableDiscoveryClient 适用于所有的注册中心
// 全局配置，若使用局部配置，则在对应的服务中加上configuration属性即可，即
// @FeignClient(value = "SERVICE-PROVIDER", configuration = {FeignConfig.class, RibbonConfig.class})
@EnableFeignClients(defaultConfiguration = {FeignConfig.class, RibbonConfig.class})
@MapperScan(value = "org.example.mapper")
@EnableHystrix // 开启Hystrix
public class ServiceConsumerApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication01.class, args);
    }
}
