package com.goopal.controller;

import com.goopal.async.AsyncTask;
import com.goopal.bean.Hello;
import com.goopal.domain.User;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2016/11/3.
 */
@Log4j2
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Resource(name = "helloWorld")
    private Hello helloWorld;

    @Autowired
    @Qualifier("helloVillage")
    private Hello helloVillage;

    @Autowired
    AsyncTask asyncTask;

    //@ApiIgnore
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    @ResponseBody
    String home() {
        return "Hello SpringBoot!";
    }

    @RequestMapping("/test")
    public String test(){
        helloVillage.dispaly();
        helloWorld.dispaly();
        return "test";
    }

    @RequestMapping("/async")
    public void async() throws  Exception{
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

    /**
     * 可以直接使用@ResponseBody响应JSON
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/jsonTest3", method = RequestMethod.POST)
    public List<String> jsonTest3(HttpServletRequest request,
                                  HttpServletResponse response) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("你好");
        return list;
    }

    /**
     * JSON请求一个对象<br/>
     * （Ajax Post Data：{"name":"名称","content":"内容"}）
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/jsonTest2", method = RequestMethod.POST)
    public ModelMap jsonTest2(@RequestBody User user) {
        log.info("userName：" + user.getName());
        log.info("password：" + user.getPassword());
        ModelMap map = new ModelMap();
        map.addAttribute("result", "ok");
        return map;
    }

    /**
     * 直接读取URL参数值<br/>
     * /demo/jsonTest6.do?name=Hello&content=World
     *
     * @param demoName
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/jsonTest6", method = RequestMethod.POST)
    public ModelMap jsonTest6(@RequestParam("name") String demoName,  @RequestParam String password) {
        log.info("userName：" + demoName);
        ModelMap map = new ModelMap();
        map.addAttribute("name",demoName + "AAA");
        map.addAttribute("password",password + "BBB");
        map.addAttribute("date",new java.util.Date());
        return map;
    }

    /**
     * JSON请求一个对象，将RequestBody自动转换为JSONObject对象<br/>
     * （Ajax Post Data：{"name":"名称","content":"内容"}）
     *
     * 使用JSONObject请添加依赖
     *  <dependency>
     *      <groupId>net.sf.json-lib</groupId>
     *      <artifactId>json-lib</artifactId>
     *      <version>2.4</version>
     *      <!--指定jdk版本 -->
     *      <classifier>jdk15</classifier>
     *  </dependency>
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/jsonTest5", method = RequestMethod.POST)
    public ModelMap jsonTest5(@RequestBody JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        log.info("userName：" + name);
        ModelMap map = new ModelMap();
        map.addAttribute("userName",name);
        return map;
    }

    /**
     * 输入和输出为JSON格式的数据的方式 HttpEntity<?> ResponseEntity<?>
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/jsonTest4", method = RequestMethod.POST)
    public ResponseEntity<String> jsonTest4(HttpEntity<User> user,
                                            HttpServletRequest request, HttpSession session) {
        //获取Headers方法
        HttpHeaders headers = user.getHeaders();

        // 获取内容
        String demoContent = user.getBody().getName();

        // 这里直接new一个对象（HttpHeaders headers = new HttpHeaders();）
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("MyHeaderName", "SHANHY");

        ResponseEntity<String> responseResult = new ResponseEntity<String>(
                demoContent, responseHeaders, HttpStatus.OK);
        return responseResult;
    }
}
