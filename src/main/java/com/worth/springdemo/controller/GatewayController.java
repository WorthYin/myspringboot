package com.worth.springdemo.controller;

import com.worth.springdemo.service.impl.GatewayServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/11/28 18:18
 */
@Controller
@RequestMapping("/gateway")
public class GatewayController extends AbstractController{
    Logger logger = LoggerFactory.getLogger(getClass());

//    @Resource(name = "gatewayService")
    @Autowired
    @Qualifier("gatewayService")
    GatewayServiceImpl gatewayService;

    @Autowired
    DataSource dataSource;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object queryGateway(@RequestBody Map<String, Integer> paramMap){
        logger.info("DataSource Type:" + dataSource.getClass());
        return gatewayService.queryGatewayList(paramMap);
    }

    @RequestMapping(path = "/{Id}", method = RequestMethod.GET)
    @ResponseBody
    public Object queryGateway(@PathVariable String Id){
        logger.info("DataSource Type:" + dataSource.getClass());
        return gatewayService.selectByKey(Id);
    }

}
