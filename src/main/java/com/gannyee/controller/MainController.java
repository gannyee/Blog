package com.gannyee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gannyee on 2017/5/7.
 */

//@Controller ����ע��ķ�ʽ��������ȷ�ض������Ϊ���������Controller��
@Controller
public class MainController {

    //���ڶ���һ�������ӳ�䣬valueΪ�����url��ֵΪ'/'˵�� ������Ϊ��ҳ����method����ָ���������ͣ�һ��Ϊget �� post
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        //���������󷵻ص�ҳ�棬��ǰ��  �ص�Ϊindex.jspҳ��
        return "index";
    }
}
