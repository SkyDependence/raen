package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long id);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    /**
     * 插入用户数据
     * @param user
     */
    @Insert("insert into user (username, password, name)" +
            "values " + "(#{username},#{password},#{name})")
    void insert(User user);


    /**
     * 根据username修改属性
     * @param user
     */
    void update(User user);
}
