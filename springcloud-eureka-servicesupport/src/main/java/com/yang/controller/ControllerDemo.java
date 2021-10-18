package com.yang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ControllerDemo {
    @RequestMapping("/world")
    public String helloworld(String str) {
        System.out.println("传入的值为：" + str);
        return "传入的值为：" + str;
    }
}
