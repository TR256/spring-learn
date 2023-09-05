package com.learn.autowired.strategy.one;

import org.springframework.stereotype.Component;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo:
 */
@Component
public class FirstOneStrategy implements OneStrategy {
    @Override
    public String operate() {
        System.out.println("111111111--11111111");
        return null;
    }
}
