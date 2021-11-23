package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/t")   //localhost/t
    @ResponseBody   //ֱ����Ӧ�ַ���������תҳ��
    public String test() {
        return "SUCCESS";
    }

    @PostMapping("/login")
    @ResponseBody
    public String postMapping(User user){
        return  "<fieldset><legend>��½�ɹ�</legend>�û�����" +user.getUsername()+
                "<br>���룺"+user.getPassword()+"</fieldset>";
    }
}
