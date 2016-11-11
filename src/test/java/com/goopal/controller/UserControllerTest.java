package com.goopal.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by leon on 2016/11/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
public class UserControllerTest extends MockMvcResultMatchers {
    //模拟mvc对象类
    private MockMvc mvc;

    @Before
    public void setup() {
       /*
        * MockMvcBuilders使用构建MockMvc对象.
        */
        mvc = MockMvcBuilders.standaloneSetup(new SwaggerController()).build();

    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;
        //1. get 以下user列表，应该为空》

        //1、构建一个get请求.
        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
        System.out.println("UserControllerTest.testUserController().get");

        // 2、post提交一个user
        String requestBody = "{\"id\":1,\"name\":\"林峰\",\"password\":\"123456\",\"age\":20}";
        request = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(requestBody);
//                .param("id", "1")
//                .param("name", "林峰")
//                .param("password","123456")
//                .param("age", "20");

        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));

        // 3、get获取user列表，应该有刚才插入的数据
        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"林峰\",\"password\":\"123456\",\"age\":20}]"));


        // 4、put修改id为1的user
        requestBody = "{\"name\":\"林则徐\",\"age\":30}";
        request = MockMvcRequestBuilders.put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
//                .param("name", "林则徐")
//                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string("success"));

        // 5、get一个id为1的user
        request = MockMvcRequestBuilders.get("/users/1");
        mvc.perform(request)
                .andExpect(content().string("{\"id\":1,\"name\":\"林则徐\",\"password\":\"123456\",\"age\":30}"));


        // 6、del删除id为1的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string("success"));

        // 7、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

    }
}
