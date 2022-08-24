package com.hose.mapper;

import com.hose.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectUser(@Param("userName") String userName, @Param("userPassword")String userPassword);

    User AccountingCheck(@Param("userName") String userName);
}