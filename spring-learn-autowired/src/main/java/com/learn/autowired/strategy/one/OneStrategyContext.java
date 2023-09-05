package com.learn.autowired.strategy.one;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo: 策略模式：Key为Class
 */
@Component
public class OneStrategyContext {

    private final static Map<Class<? extends OneStrategy>, OneStrategy> oneStrategyMap = new HashMap<>();

    /**
     * 静态代码块中手动注入
     */
    static {
        registerWorkHandler(FirstOneStrategy.class);
        registerWorkHandler(SecondOneStrategy.class);
    }


    public static void registerWorkHandler(Class<? extends OneStrategy> workHandlerClass) {
        try {
            OneStrategy handler = workHandlerClass.newInstance();
            oneStrategyMap.put(workHandlerClass, handler);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(workHandlerClass.getName() + "注册失败！");
        }
    }

    public static OneStrategy getWorkHandler(Class<? extends OneStrategy> workHandlerClass) {
        return oneStrategyMap.get(workHandlerClass);
    }
}
