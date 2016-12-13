package com.iteye.wwwcomy.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iteye.wwwcomy.dao.UserDao;
import com.iteye.wwwcomy.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User loadUser(String userName) {
        return null;
    }

    @Override
    @Transactional
    public User loadUser(String userName, String password) {
        return null;
    }

    @Override
    public User save(User entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(User entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User getById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getByIds(String[] ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
}
