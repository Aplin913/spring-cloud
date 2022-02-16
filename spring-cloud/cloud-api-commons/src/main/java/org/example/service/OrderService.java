package org.example.service;

import org.example.po.Order;
import org.example.utils.CommonResult;

public interface OrderService {
    CommonResult<Order> selectById(Integer id);
}
