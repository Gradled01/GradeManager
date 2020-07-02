package com.good;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String account;
    private String password;
    private String grade_normal;
    private String grade_test;
    private String class_num;
    private String type;
    private String total;

    public User(String username, String account, String password, String grade_normal,String grade_test, String class_num, String type,String total) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.grade_normal = grade_normal;
        this.grade_test = grade_test;
        this.class_num = class_num;
        this.type = type;
        this.total = total;
    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public String getGrade_normal() {
        return grade_normal;
    }

    public void setGrade_normal(String grade_normal) {
        this.grade_normal = grade_normal;
    }

    public String getGrade_test() {
        return grade_test;
    }

    public void setGrade_test(String grade_test) {
        this.grade_test = grade_test;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
