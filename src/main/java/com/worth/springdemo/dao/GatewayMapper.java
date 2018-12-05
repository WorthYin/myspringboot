package com.worth.springdemo.dao;

import com.worth.springdemo.domain.Gateway;
import com.worth.springdemo.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface GatewayMapper extends MyMapper<Gateway> {
    List<Gateway> queryGatewayList();
}