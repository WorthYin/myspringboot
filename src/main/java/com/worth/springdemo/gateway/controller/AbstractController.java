package com.worth.springdemo.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @date 2018/11/28 18:16
 */
public abstract class AbstractController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HttpServletRequest request;

    protected String getContextPath(){
        return request.getContextPath();
    }
}
