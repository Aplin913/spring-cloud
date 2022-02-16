package org.example.facade;

import org.example.mapper.OrderMapper;
import org.example.po.Order;
import org.example.service.OrderService;
import org.example.utils.CommonResult;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public CommonResult<Order> selectById(Integer id) {
        return new CommonResult<Order>(200, "查询成功！", orderMapper.selectById(id));
    }
}
