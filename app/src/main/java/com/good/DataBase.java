package com.good;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    Map<String, User> userMap = new HashMap<>();
    List<User> user_list = new ArrayList<>();

    public Map<String, User> getUserMap() {

        userMap.put("小明",new User("小明","001","001","90","90","A1","captain","90"));
        userMap.put("小芳",new User("小芳","002","002","80","90","A1","student","87"));
        userMap.put("小王",new User("小王","003","003","70","90","A1","student","84"));
        userMap.put("张三",new User("张三","004","004","80","80","A1","student","80"));

        return userMap;
    }

    public List<User> getUser_list() {

        user_list.add(userMap.get("小明"));
        user_list.add(userMap.get("小芳"));
        user_list.add(userMap.get("小王"));
        user_list.add(userMap.get("张三"));

        return user_list;
    }

//    public List<User> getUser_list() {
//
//        user_list.add(new User("小明","001","001",90,90,"A1","captain"));
//        user_list.add(new User("小芳","002","002",80,90,"A1","student"));
//        user_list.add(new User("小王","003","003",70,90,"A1","student"));
//        user_list.add(new User("袁老师","008","008",0,0,"A1","teacher"));
//
//        return user_list;
//    }
}
