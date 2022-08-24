package com.hose.service.Impl;

import com.hose.mapper.OrderMapper;
import com.hose.pojo.Order;
import com.hose.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    public int insert(Order record)
    {
        return orderMapper.insert(record);
    }

    @Override
    public Order selectspecifying(Integer houseId, Integer userId) {
        return orderMapper.selectspecifying(houseId,userId);
    }

    @Override
    public List<Order> selectAllByUserId(Integer userId) {
        return orderMapper.selectAllByUserId(userId);
    }
}
