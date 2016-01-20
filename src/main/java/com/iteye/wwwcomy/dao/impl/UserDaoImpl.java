package com.iteye.wwwcomy.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.iteye.wwwcomy.dao.UserDao;
import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.utils.StringUtil;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @SuppressWarnings("rawtypes")
    @Override
    public User loadUser(String userName) {
        if (StringUtil.isBlankOrNull(userName)) {
            return null;
        } else {
            Query q = this.getSession().createQuery("select t from User t where t.username=:userName");
            q.setString("userName", userName);
            q.setLockMode("t", LockMode.NONE);
            q.setFirstResult(0);
            q.setFetchSize(1);
            q.setMaxResults(1);
            List list = q.list();
            if (CollectionUtils.isEmpty(list)) {
                return null;
            } else {
                return (User) list.get(0);
            }
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    @Transactional
    public User loadUser(String userName, String password) {
        if (StringUtil.isBlankOrNull(userName) || StringUtil.isBlankOrNull(password)) {
            return null;
        } else {
            Query q = this.getSession().createQuery(
                    "select t from User t where t.username=:userName and password=:password");
            q.setString("userName", userName);
            q.setString("password", password);
            q.setLockMode("t", LockMode.NONE);
            q.setFirstResult(0);
            q.setFetchSize(1);
            q.setMaxResults(1);
            List list = q.list();
            if (CollectionUtils.isEmpty(list)) {
                return null;
            } else {
                return (User) list.get(0);
            }
        }
    }
}
