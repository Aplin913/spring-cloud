package org.example.controller;

import org.example.po.Order;
import org.example.po.User;
import org.example.service.OrderService;
import org.example.service.UserFeignClient;
import org.example.utils.CommonResult;
import org.example.vo.OrderVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final UserFeignClient userFeignClient;

    public OrderController(OrderService orderService, UserFeignClient userFeignClient) {
        this.orderService = orderService;
        this.userFeignClient = userFeignClient;
    }

    @RequestMapping("/{id}")
    public CommonResult<OrderVO> selectById(@PathVariable("id") Integer id){
        Order order = orderService.selectById(id).getData();
        CommonResult<User> result = userFeignClient.selectById(order.getUserId());
        User user = result.getData();
        OrderVO orderVO = new OrderVO();
        orderVO.setId(order.getId());
        orderVO.setUser(user);
        orderVO.setProductName(order.getProductName());
        orderVO.setPrice(order.getPrice());

        return new CommonResult<OrderVO>(200, "查询成功！", orderVO);
    }

    public CommonResult<OrderVO> downgradeHandler(Integer id){
        return new CommonResult<OrderVO>(201, "系统繁忙，请稍后再试....", null);
    }
}
