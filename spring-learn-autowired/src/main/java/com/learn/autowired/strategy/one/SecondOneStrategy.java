package com.learn.autowired.strategy.one;

import org.springframework.stereotype.Component;

/**
 * @Author: MengXH
 * @Date: 2023/9/5
 * @Todo:
 */
@Component
public class SecondOneStrategy implements OneStrategy {
    @Override
    public String operate() {
        System.out.println("222222--222222");
        return null;
    }
}
