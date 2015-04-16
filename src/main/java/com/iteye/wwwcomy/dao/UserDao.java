package com.iteye.wwwcomy.dao;

import com.iteye.wwwcomy.model.User;

public interface UserDao extends BaseDao<User> {

    public User loadUser(String userName);

    public User loadUser(String userName, String password);

}
