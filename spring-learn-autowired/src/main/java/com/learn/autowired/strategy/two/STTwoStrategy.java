package com.learn.autowired.strategy.two;

import org.springframework.stereotype.Component;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo: 已两个大写字母开头，beanName和Class.getSimpleName相同
 */
@Component
public class STTwoStrategy implements TwoStrategy {
    @Override
    public String operate() {
        System.out.println("STTwoStrategy");
        return null;
    }
}
