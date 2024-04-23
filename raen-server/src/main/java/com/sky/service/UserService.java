package com.sky.service;

import com.sky.dto.UserDTO;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 新增用户
     * @param userDTO
     */
    void save(UserDTO userDTO);


    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getById(Long id);

    /**
     * 编辑用户信息
     * @param userDTO
     */
    void update(UserDTO userDTO);
}
