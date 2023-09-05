package com.learn.aop.strategy.one;

import org.springframework.stereotype.Component;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo:
 */
@Component
public class TwoOneStrategy implements OneStrategy {
    @Override
    public String operate() {
        System.out.println("222222--222222");
        return null;
    }
}
