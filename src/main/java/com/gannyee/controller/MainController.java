package com.gannyee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gannyee on 2017/5/7.
 */

//@Controller 采用注解的方式，可以明确地定义该类为处理请求的Controller类
@Controller
public class MainController {

    //用于定义一个请求的映射，value为请求的url，值为'/'说明 该请求为首页请求，method用于指定请求类型，一般为get 或 post
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        //处理该请求后返回的页面，当前返  回的为index.jsp页面
        return "index";
    }
}
