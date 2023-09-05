package com.learn.aop.strategy.two;

import org.springframework.stereotype.Component;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo:
 */
@Component
public class SOTwoStrategy implements TwoStrategy {
    @Override
    public String operate() {
        System.out.println("222222222222222--11111111111111111");
        return null;
    }
}
