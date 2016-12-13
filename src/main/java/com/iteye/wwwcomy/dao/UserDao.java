package com.iteye.wwwcomy.dao;

import org.apache.ibatis.annotations.Param;

import com.iteye.wwwcomy.model.User;

public interface UserDao extends BaseDao<User> {

    public User loadUser(@Param("userName") String userName);

    public User loadUser(String userName, String password);

}
