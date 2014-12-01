package com.iteye.wwwcomy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iteye.wwwcomy.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

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
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void delete(String id) {
        Object obj = getById(id);
        if (obj != null) {
            getSession().delete(obj);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
    }

    @SuppressWarnings("unchecked")
    public T getById(String id) {
        return (T) getSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getByIds(String[] ids) {
        if (ids == null || ids.length == 0) {
            return Collections.EMPTY_LIST;
        }
        return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")
                .setParameterList("ids", ids).list();
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }
}
