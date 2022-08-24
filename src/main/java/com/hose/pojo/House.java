package com.hose.pojo;

import java.util.Arrays;
import java.util.Date;

//房屋信息
public class House {

    private Integer houseId;

    private String houseDescription;

    private String houseModel;

    private String houseArea;

    private String houseFloor;

    private String houseType;

    private Integer housePrice;

    private String houseAddress;

    private String houseLinkman;

    private String housePhonenumber;

    private String houseImageName;

    private Date houseTime;

    private Integer userId;

    private byte[] houseImage;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription == null ? null : houseDescription.trim();
    }

    public String getHouseModel() {
        return houseModel;
    }

    public void setHouseModel(String houseModel) {
        this.houseModel = houseModel == null ? null : houseModel.trim();
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public String getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(String houseFloor) {
        this.houseFloor = houseFloor == null ? null : houseFloor.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public Integer getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Integer housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    public String getHouseLinkman() {
        return houseLinkman;
    }

    public void setHouseLinkman(String houseLinkman) {
        this.houseLinkman = houseLinkman == null ? null : houseLinkman.trim();
    }

    public String getHousePhonenumber() {
        return housePhonenumber;
    }

    public void setHousePhonenumber(String housePhonenumber) {
        this.housePhonenumber = housePhonenumber == null ? null : housePhonenumber.trim();
    }

    public String getHouseImageName() {
        return houseImageName;
    }

    public void setHouseImageName(String houseImageName) {
        this.houseImageName = houseImageName == null ? null : houseImageName.trim();
    }

    public Date getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(Date houseTime) {
        this.houseTime = houseTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public byte[] getHouseImage() {
        return houseImage;
    }

    public void setHouseImage(byte[] houseImage) {
        this.houseImage = houseImage;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", houseDescription='" + houseDescription + '\'' +
                ", houseModel='" + houseModel + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", houseFloor='" + houseFloor + '\'' +
                ", houseType='" + houseType + '\'' +
                ", housePrice=" + housePrice +
                ", houseAddress='" + houseAddress + '\'' +
                ", houseLinkman='" + houseLinkman + '\'' +
                ", housePhonenumber='" + housePhonenumber + '\'' +
                ", houseImageName='" + houseImageName + '\'' +
                ", houseTime=" + houseTime +
                ", userId=" + userId +
                '}';
    }
}