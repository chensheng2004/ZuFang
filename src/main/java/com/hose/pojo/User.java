package com.hose.pojo;

//用户
public class User {
    private Integer userId;

    private String userAccountName;

    private String userPassword;

    private String userPhonenumber;

    private String userNickname;

    private String userShoppingtrolley;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName == null ? null : userAccountName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber == null ? null : userPhonenumber.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserShoppingtrolley() {
        return userShoppingtrolley;
    }

    public void setUserShoppingtrolley(String userShoppingtrolley) {
        this.userShoppingtrolley = userShoppingtrolley == null ? null : userShoppingtrolley.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccountName='" + userAccountName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhonenumber='" + userPhonenumber + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userShoppingtrolley='" + userShoppingtrolley + '\'' +
                '}';
    }
}