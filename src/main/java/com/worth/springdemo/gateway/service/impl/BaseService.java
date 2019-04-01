package com.worth.springdemo.gateway.service.impl;

import com.worth.springdemo.gateway.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/11/28 18:35
 */
public class BaseService<T> implements IService<T>{

    @Autowired
    private Mapper<T> tMapper;
    public Mapper<T> gettMapper() {
        return tMapper;
    }

    @Override
    public T selectByKey(Object key) {
        //说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
        return tMapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) {
        //说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
        return tMapper.insert(entity);
    }

    @Override
    public int delete(Object key) {
        //说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
        return tMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(T entity) {
        //说明：根据主键更新实体全部字段，null值会被更新
        return tMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        //根据主键更新属性不为null的值
        return tMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        //说明：根据Example条件进行查询
        //重点：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
        return tMapper.selectByExample(example);
    }
}
