package com.iteye.wwwcomy.dao;

import java.util.List;

public interface BaseDao<T> {
    /**
     * 保存实体
     * 
     * @param entity
     */
    T save(T entity);

    /**
     * 删除实体
     * 
     * @param id
     */
    void delete(String id);

    /**
     * 更新实体
     * 
     * @param entity
     */
    void update(T entity);

    /**
     * 按id查询
     * 
     * @param id
     * @return
     */
    T getById(String id);

    /**
     * 按id查询
     * 
     * @param ids
     * @return
     */
    List<T> getByIds(String[] ids);

    /**
     * 查询所有
     * 
     * @return
     */
    List<T> findAll();
}
