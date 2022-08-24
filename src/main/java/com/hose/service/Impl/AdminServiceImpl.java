package com.hose.service.Impl;

import com.hose.mapper.AdminMapper;
import com.hose.pojo.Admin;
import com.hose.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin selectAdmin(String accountName, String password) {
        return adminMapper.selectAdmin(accountName,password);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }
}
