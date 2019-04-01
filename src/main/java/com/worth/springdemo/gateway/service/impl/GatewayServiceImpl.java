package com.worth.springdemo.gateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.worth.springdemo.gateway.dao.GatewayMapper;
import com.worth.springdemo.gateway.model.Gateway;
import com.worth.springdemo.exception.BusinessException;
import com.worth.springdemo.gateway.service.GatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Administrator
 * @date 2018/11/28 18:45
 */
@Service("gatewayService")
@Slf4j
public class GatewayServiceImpl extends BaseService<Gateway> implements GatewayService {

    @Autowired
    private GatewayMapper gatewayMapper;

    @Override
    public List<Gateway> queryGatewayList(Map<String,Integer> params) throws BusinessException{
        if (params.get("page") == null || params.get("rows") == null){
            throw new BusinessException(400,"缺少必要参数");
        }
        PageHelper.startPage(params.get("page"), params.get("rows"));
        return gatewayMapper.queryGatewayList();
    }

    @Override
    public void deleteBatch(String[] ids) {
        Arrays.stream(ids).forEach(id->gatewayMapper.deleteByPrimaryKey(id));
    }
}
