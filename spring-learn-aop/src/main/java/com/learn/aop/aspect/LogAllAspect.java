package com.learn.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: MengXH
 * @Date: 2023/9/4
 * @Todo:
 */
@Aspect
@Component//必须加Component注解
public class LogAllAspect {


    @Pointcut("execution(* com.learn.aop.controller.*Controller.*(..))")
    public void point() {

    }


    @Before(value = "point()")
    public void before() {
        System.out.println("执行了前置方法");
    }

    @AfterReturning(value = "point()")
    public void afterReturn() {
        System.out.println("返回后执行方法");
    }

    @After(value = "point()")
    public void after() {
        System.out.println("执行了后置方法");
    }


    @Around(value = "point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 拦截的实体类
        Object target = proceedingJoinPoint.getTarget();
        System.out.println(target.getClass().getSimpleName());
        //拦截的方法名称
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println(methodName);
        //拦截的方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println(args);
        //拦截的放参数类型
        Class[] parameterTypes = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getParameterTypes();
        Method method = target.getClass().getMethod(methodName, parameterTypes);
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType.getSimpleName());
        }
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("耗时：" + duration + " ms");
        return result;
    }
}
