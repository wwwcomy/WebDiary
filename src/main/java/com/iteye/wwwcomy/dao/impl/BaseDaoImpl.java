package com.iteye.wwwcomy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iteye.wwwcomy.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
    @Resource
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        // 使用反射技术得到T的真实类型
        // 获取当前new的对象的泛型的父类
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        System.out.println("clazz--->" + clazz);
    }

    /**
     * 获取当前可用的Session对象
     * 
     * @return
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 获取新的Session对象
     * 
     * @return
     */
    protected Session openSession() {
        return sessionFactory.openSession();
    }

    public void delete(String id) {
        Object obj = getById(id);
        if (obj != null) {
            getCurrentSession().delete(obj);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getCurrentSession().createQuery("FROM " + clazz.getSimpleName()).list();
    }

    @SuppressWarnings("unchecked")
    public T getById(String id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getByIds(String[] ids) {
        if (ids == null || ids.length == 0) {
            return Collections.EMPTY_LIST;
        }
        return getCurrentSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")
                .setParameterList("ids", ids).list();
    }

    public T save(T entity) {
        Session session = null;
        try {
            session = getCurrentSession();
            session.save(entity);
            return entity;
        } catch (HibernateException e) {
            logger.error("Hibernate exception executing save", e);
            // rollback(txn);
            throw e;
        } finally {
            // close(session);
        }
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    protected Class<T> getClazz() {
        return clazz;
    }
}
