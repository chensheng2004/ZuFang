package com.hose.service.Impl;

import com.hose.mapper.UserMapper;
import com.hose.pojo.User;
import com.hose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User LoginCheck(String userName, String userPassword) {return userMapper.selectUser(userName,userPassword);}

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User AccountingCheck(String userName) {
        return userMapper.AccountingCheck(userName);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
