package com.iteye.wwwcomy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
     * 替换实体
     * 
     * @param entity
     */
    void replace(T entity);

    /**
     * 按id查询
     * 
     * @param id
     * @return
     */
    T findById(@Param("id") String id);

    /**
     * 按id查询
     * 
     * @param ids
     * @return
     */
    List<T> findByIds(String[] ids);

    /**
     * 查询所有
     * 
     * @return
     */
    List<T> findAll();
}
