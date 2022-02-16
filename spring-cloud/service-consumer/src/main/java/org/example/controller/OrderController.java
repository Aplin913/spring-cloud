package org.example.controller;

import com.alibaba.fastjson.JSON;
import org.example.po.Order;
import org.example.po.User;
import org.example.service.OrderService;
import org.example.utils.CommonResult;
import org.example.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final RestTemplate restTemplate;

    public OrderController(OrderService orderService, RestTemplate restTemplate) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{id}")
    public CommonResult<OrderVO> selectById(@PathVariable("id") Integer id){
        Order order = orderService.selectById(id).getData();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        // 设置请求头
        List<String> list = new ArrayList<>();
        list.add("application/json;charset=UTF-8");
        headers.put("Content-Type", list);

        // 请求路径
        // String url = "http://localhost:8080/user/" + order.getUserId();

        // 使用ribbon进行负载均衡的时候，应使用服务名代替具体的ip+端口
//        String url = "http://service-provider/user/" + order.getUserId();
        String url = "http://SERVICE-PROVIDER/user/" + order.getUserId();
        ResponseEntity<CommonResult<User>> entity = restTemplate.exchange(url,
                HttpMethod.GET, new HttpEntity<>(headers),
                new ParameterizedTypeReference<CommonResult<User>>() {});

        CommonResult<User> result = entity.getBody();
        User user = result.getData();
        OrderVO orderVO = new OrderVO();
        orderVO.setId(order.getId());
        orderVO.setUser(user);
        orderVO.setProductName(order.getProductName());
        orderVO.setPrice(order.getPrice());

        return new CommonResult<OrderVO>(200, "查询成功！", orderVO);
    }
}
