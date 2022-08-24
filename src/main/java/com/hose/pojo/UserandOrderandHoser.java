package com.hose.pojo;

import org.aspectj.weaver.ast.Or;

//用户和用户订单数量，房源数量
public class UserandOrderandHoser {
    User user;

    int ordersize;

   int housesize;

    public UserandOrderandHoser(User user, int ordersize, int housesize) {
        this.user = user;
        this.ordersize = ordersize;
        this.housesize = housesize;
    }

    public UserandOrderandHoser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrdersize() {
        return ordersize;
    }

    public void setOrdersize(int ordersize) {
        this.ordersize = ordersize;
    }

    public int getHousesize() {
        return housesize;
    }

    public void setHousesize(int housesize) {
        this.housesize = housesize;
    }
}
