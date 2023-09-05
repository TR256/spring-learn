package com.learn.autowired.controller;


import com.learn.autowired.strategy.one.FirstOneStrategy;
import com.learn.autowired.strategy.one.OneStrategy;
import com.learn.autowired.strategy.one.OneStrategyContext;
import com.learn.autowired.strategy.two.SOTwoStrategy;
import com.learn.autowired.strategy.two.TwoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MengXH
 * @Date: 2023/9/4
 * @Todo:
 */
@RestController
@RequestMapping("/test2")
public class Test2Controller {

    /**
     * 自动注入，默认的类名
     */
    @Autowired
    @Qualifier("firstOneStrategy")
    private OneStrategy firstOneStrategy;

    @Autowired
    @Qualifier("secondOneStrategy")
    private OneStrategy secondOneStrategy;

    @RequestMapping("/t1")
    public String t1(String name, Integer id) {
        firstOneStrategy.operate();
        System.out.println("执行了方法111");
        return "OK";
    }

    @RequestMapping("/t2")
    public String t2(String name, Integer id) {
        System.out.println("执行了方法222");
        secondOneStrategy.operate();
        return "OK";
    }



}
