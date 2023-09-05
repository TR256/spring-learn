package com.learn.autowired.strategy.two;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo:
 */
@Component
@Primary
public class SOTwoStrategy implements TwoStrategy {
    @Override
    public String operate() {
        System.out.println("SOTwoStrategy");
        return null;
    }
}
