package com.hose.mapper;

import com.hose.pojo.Admin;
import com.hose.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    List<Admin> selectAll();


    Admin selectAdmin(@Param("accountName") String accountName, @Param("password")String password);

}