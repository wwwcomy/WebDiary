package com.iteye.wwwcomy.model;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.iteye.wwwcomy.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserTest {
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    @Transactional
    public void loadUser() {
        User user = userDao.loadUser("abc");
        System.out.println(user);
    }

    @Test
    @Transactional
    public void loadUserById() {
        User user = userDao.findById(1);
        System.out.println(user);
    }

}
