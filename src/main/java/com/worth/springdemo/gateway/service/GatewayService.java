package com.worth.springdemo.gateway.service;

import com.worth.springdemo.gateway.model.Gateway;

import java.util.List;
import java.util.Map;

public interface GatewayService extends IService<Gateway>{
    public List<Gateway> queryGatewayList(Map<String,Integer> params);
    public void deleteBatch(String[] ids);
}
