package com.leifeng.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leifeng
 * @Date 2017-10-23
 **/
@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String helloWorld(){
        logger.info("访问hello world");
        return "Hello world";
    }

    @RequestMapping("/{name}")
    public String helloName(@PathVariable String name){
        logger.info("访问hello name,name={}",name);
        return "hello "+name;
    }
}
