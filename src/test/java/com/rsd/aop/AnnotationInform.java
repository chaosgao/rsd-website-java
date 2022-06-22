package com.rsd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationInform {

    @Pointcut("execution(* com.rsd.service.impl.*.*(..))")
    private void pointcut(){

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("&&&&&&&&&前置通知&&&&&&&&&&");
    }

    @After("execution(* com.rsd.service.impl.*.*(..))")
    public void after() {
        System.out.println("&&&&&&&&&后置通知&&&&&&&&&&");
    }

    @Around("execution(* com.rsd.service.impl.*.*(..))")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("&&&&&&&&&环绕通知(TOP)&&&&&&&&&&");
        Object proceed = joinPoint.proceed();
        System.out.println("&&&&&&&&&环绕通知(BOTTOM)&&&&&&&&&&");
        return proceed;
    }

}
