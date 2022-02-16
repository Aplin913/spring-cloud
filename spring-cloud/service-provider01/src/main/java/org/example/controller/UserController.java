package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.po.User;
import org.example.service.UserService;
import org.example.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @HystrixCommand(fallbackMethod = "downgradeHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    @GetMapping("/{id}")
    public CommonResult<User> selectById(@PathVariable("id") Integer id) {
        System.out.println("8081");
        // 模拟超时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.selectById(id);
    }

    public CommonResult<User> downgradeHandler(Integer id) {
//        String result = "线程池：" + Thread.currentThread().getName() + "，系统繁忙，请稍后再试....";
        return new CommonResult<User>(201, "查询失败，系统繁忙，请稍后再试....", null);
    }
}
