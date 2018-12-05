package com.worth.springdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Administrator
 * @date 2018/12/4 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class GatewayControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
    }

    @Test
    public void queryGateway() throws Exception{
        String json="{\n" +
                "\t\"page\": 2,\n" +
                "    \"rows\": 2\n" +
                "}";
        mvc.perform(MockMvcRequestBuilders.get("/gateway/1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes()) //传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void queryGatewayList() throws Exception{
        String json="{\n" +
                "\t\"page\": 2,\n" +
                "    \"rows\": 2\n" +
                "}";
        mvc.perform(MockMvcRequestBuilders.get("/gateway")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
