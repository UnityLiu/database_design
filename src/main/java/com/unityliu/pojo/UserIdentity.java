package com.unityliu.pojo;

import java.util.Map;

public class UserIdentity {
    private String userTheName;//姓名
    private String userSex;     //性别
    private String bornDate;    //出生日期
    private String userName;   //邮箱
    private String password;   //密码
    private String userIdentity;//账户类型

    public String getUserTheName() {
        return userTheName;
    }

    public void setUserTheName(String userTheName) {
        this.userTheName = userTheName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }



    public UserIdentity(Map<String,String[]> paramMap){
        try {
            this.userTheName = paramMap.get("userTheName")[0].equals("")||paramMap.get("userTheName")[0]==null?null:paramMap.get("userTheName")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.userSex = paramMap.get("userSex")[0].equals("")||paramMap.get("userSex")[0]==null?null:paramMap.get("userSex")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.bornDate = paramMap.get("bornDate")[0].equals("")||paramMap.get("bornDate")[0]==null?null:paramMap.get("bornDate")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.userName = paramMap.get("userName")[0].equals("")||paramMap.get("userName")[0]==null?null:paramMap.get("userName")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.password = paramMap.get("userPassword")[0].equals("")||paramMap.get("userPassword")[0]==null?null:paramMap.get("userPassword")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.userIdentity = paramMap.get("position")[0].equals("")||paramMap.get("position")[0]==null?null:paramMap.get("position")[0];
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public UserIdentity(String userTheName, String userSex, String bornDate, String userName, String password, String userIdentity) {
        this.userTheName = userTheName;
        this.userSex = userSex;
        this.bornDate = bornDate;
        this.userName = userName;
        this.password = password;
        this.userIdentity = userIdentity;
    }

    @Override
    public String toString() {
        return "UserIdentity{" +
                "userTheName='" + userTheName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                '}';
    }
}
