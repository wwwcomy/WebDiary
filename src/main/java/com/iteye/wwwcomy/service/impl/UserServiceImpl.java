package com.iteye.wwwcomy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iteye.wwwcomy.dao.UserDao;
import com.iteye.wwwcomy.model.User;

@Service
public class UserServiceImpl {
    @Resource
    private UserDao userDao;

    public User loadUser(String userName) {
        return userDao.loadUser(userName);
    }

    public User loadUser(String userName, String password) {
        return userDao.loadUser(userName, password);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
