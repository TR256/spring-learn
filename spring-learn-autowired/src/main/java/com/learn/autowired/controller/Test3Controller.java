package com.learn.autowired.controller;


import com.learn.autowired.strategy.one.OneStrategy;
import com.learn.autowired.strategy.two.TwoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: MengXH
 * @Date: 2023/9/4
 * @Todo:
 */
@RestController
@RequestMapping("/test3")
public class Test3Controller {

    /**
     * 自动注入，默认的类名
     */
    @Autowired
    private TwoStrategy twoStrategy;

    @Autowired
    @Qualifier("STTwoStrategy")
    private TwoStrategy sttTwoStrategy;


    @RequestMapping("/t1")
    public String t1(String name, Integer id) {
        twoStrategy.operate();
        return "OK";
    }


    @RequestMapping("/t2")
    public String t2(String name, Integer id) {
        sttTwoStrategy.operate();
        return "OK";
    }


}
