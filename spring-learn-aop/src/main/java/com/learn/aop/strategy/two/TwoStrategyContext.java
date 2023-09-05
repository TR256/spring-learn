package com.learn.aop.strategy.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo: 策略模式：Key为Class
 */
@Component
public class TwoStrategyContext {

    @Autowired
    private final Map<String, TwoStrategy> twoStrategyMap = new HashMap<>();


    public TwoStrategy getWorkHandler(Class<? extends TwoStrategy> workHandlerClass) {
        return twoStrategyMap.get(workHandlerClass.getSimpleName());
    }
}
