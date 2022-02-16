package org.example.facade;

import org.example.mapper.UserMapper;
import org.example.po.User;
import org.example.service.UserService;
import org.example.utils.CommonResult;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final  UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public CommonResult<User> selectById(Integer id) {
        return new CommonResult<User>(200, "查询成功！", userMapper.selectById(id));
    }
}
