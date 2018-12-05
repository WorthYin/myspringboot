package com.worth.springdemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.worth.springdemo.dao.GatewayMapper;
import com.worth.springdemo.domain.Gateway;
import com.worth.springdemo.exception.BusinessException;
import com.worth.springdemo.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/11/28 18:45
 */
@Service("gatewayService")
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
