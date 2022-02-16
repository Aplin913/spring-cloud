package org.example.service;

import org.example.po.User;
import org.example.utils.CommonResult;

public interface UserService {
    CommonResult<User> selectById(Integer id);
}
