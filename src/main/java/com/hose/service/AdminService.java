package com.hose.service;

import com.hose.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    Admin selectAdmin(String accountName,String password);

    List<Admin> selectAll();
}
