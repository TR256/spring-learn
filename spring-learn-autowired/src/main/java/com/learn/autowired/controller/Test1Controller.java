package com.learn.autowired.controller;


import com.learn.autowired.strategy.one.FirstOneStrategy;
import com.learn.autowired.strategy.one.OneStrategy;
import com.learn.autowired.strategy.one.OneStrategyContext;
import com.learn.autowired.strategy.two.SOTwoStrategy;
import com.learn.autowired.strategy.two.TwoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/test1")
public class Test1Controller {

    /**
     * 自动注入，默认的类名
     */
    @Autowired
    private final Map<String, OneStrategy> oneStrategyMap = new HashMap<>();

    @Autowired
    private final Map<String, TwoStrategy> twoStrategyMap = new HashMap<>();

    @RequestMapping("/t1")
    public String t1(String name, Integer id) {
        OneStrategy oneStrategy = OneStrategyContext.getWorkHandler(FirstOneStrategy.class);
        oneStrategy.operate();
        System.out.println("执行了方法111");
        return "OK";
    }

    @RequestMapping("/t2")
    public String t2(String name, Integer id) {
        System.out.println("执行了方法");
        OneStrategy oneStrategy = oneStrategyMap.get("twoWorkHandler");
        oneStrategy.operate();
        return "OK";
    }

    @RequestMapping("/t3")
    public String t3(String name, Integer id) {
        System.out.println("执行了方法");
        TwoStrategy workHandler = twoStrategyMap.get(SOTwoStrategy.class.getSimpleName());
        workHandler.operate();
        return "OK";
    }

}
