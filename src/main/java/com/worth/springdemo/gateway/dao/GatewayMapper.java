package com.worth.springdemo.gateway.dao;

import com.worth.springdemo.gateway.model.Gateway;
import com.worth.springdemo.util.MyMapper;

import java.util.List;

public interface GatewayMapper extends MyMapper<Gateway> {
    List<Gateway> queryGatewayList();
}