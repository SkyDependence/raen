package com.sky.service.impl;

import com.sky.constant.MessageConstant;
import com.sky.dto.UserDTO;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.UserMapper;
import com.sky.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    public User login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        User user = userMapper.getByUsername(username);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // 对前端传过来的密码进行md5加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //3、返回实体对象
        return user;
    }

    /**
     * 新增用户
     * @param userDTO
     */
    public void save(UserDTO userDTO) {
        System.out.println("当前线程的id:" + Thread.currentThread().getId());

        User user = new User();

        // 对象属性copy
        BeanUtils.copyProperties(userDTO, user);

        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

        userMapper.insert(user);

    }


    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User getById(Long id) {
        User user = userMapper.getById(id);
        user.setPassword("****");
        return user;
    }

    /**
     * 修改用户信息
     * @param userDTO
     */
    public void update(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        // employee.setUpdateTime(LocalDateTime.now());
        // employee.setUpdateUser(BaseContext.getCurrentId());

        userMapper.update(user);
    }
}
