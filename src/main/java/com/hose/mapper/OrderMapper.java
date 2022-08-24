package com.hose.mapper;

import com.hose.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    int insert(Order record);

    Order selectspecifying(@Param("houseId") Integer houseId,@Param("userId") Integer userId);

    List<Order> selectAllByUserId(Integer userId);
}