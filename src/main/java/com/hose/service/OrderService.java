package com.hose.service;

import com.hose.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    int insert(Order record);

    Order selectspecifying(Integer houseId,Integer userId);

    List<Order> selectAllByUserId(Integer userId);
}
