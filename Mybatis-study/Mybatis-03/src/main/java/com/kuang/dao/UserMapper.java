package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    /*查询全部用户*/
    List<User> getUserList();

    /*根据ID查询用户*/
    User getUserById(int Id);

    /* 分页 */
    List<User> getUserByLimit(HashMap<String, Integer> map);

}
