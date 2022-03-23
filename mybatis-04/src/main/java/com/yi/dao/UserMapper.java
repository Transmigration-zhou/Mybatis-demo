package com.yi.dao;

import com.yi.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数必须加@Param
    @Select("select * from mybatis.user where id= #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into mybatis.user(id,name,pwd) values (#{id},#{name},#{password})")
    void addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    void deleteUser(@Param("uid") int id);
}
