package com.imocc.usemybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping(value = "/test")
    public String test() {
        return "Hello World";
    }
}
