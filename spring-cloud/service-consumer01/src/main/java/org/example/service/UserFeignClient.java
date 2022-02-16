package org.example.service;

import org.example.po.User;
import org.example.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "SERVICE-PROVIDER")
//@FeignClient(value = "service-provider")
@RequestMapping("/user")
public interface UserFeignClient {
    @GetMapping("/{id}")
    public CommonResult<User> selectById(@PathVariable("id") Integer id);
}
