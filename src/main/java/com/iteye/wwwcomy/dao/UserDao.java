package com.iteye.wwwcomy.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iteye.wwwcomy.model.User;

@Repository
public interface UserDao extends BaseDao<User> {

    public User loadUser(@Param("userName") String userName);

    public User loadUser(String userName, String password);
    
}
