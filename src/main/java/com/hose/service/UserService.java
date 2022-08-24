package com.hose.service;

import com.hose.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User LoginCheck(String userName,String userPassword);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(User record);

    int insert(User record);

    User AccountingCheck(@Param("userName") String userName);

    List<User> selectAll();

    int deleteByPrimaryKey(Integer userId);

}
