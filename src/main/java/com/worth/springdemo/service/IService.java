package com.worth.springdemo.service;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/11/28 18:22
 */
public interface IService<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

}
