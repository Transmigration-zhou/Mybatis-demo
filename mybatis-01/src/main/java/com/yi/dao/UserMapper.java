package com.yi.dao;

import com.yi.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //增加一个用户
    void addUser(User user);

    //修改用户
    void updateUser(User user);

    //删除一个用户
    void deleteUser(int id);

    //使用万能的Map
    void addUser2(Map<String, Object> map);

    User getUserById2(Map<String, Object> map);

    //模糊查询
    List<User> getUserLike(String value);
}
