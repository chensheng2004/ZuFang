package com.hose.pojo;

import java.util.Date;

//订单
public class Order {
    private Integer orderId;

    private Integer houseId;

    private Integer userId;

    private Date orderTime;

    public Order() {
    }

    public Order(Integer houseId, Integer userId, Date orderTime) {
        this.houseId = houseId;
        this.userId = userId;
        this.orderTime = orderTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}