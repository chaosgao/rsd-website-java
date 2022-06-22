package com.rsd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ThreeLinks {

    public void inform1(JoinPoint joinPoint){
        System.out.println("***********前置通知*********");
    }

    public void inform2(JoinPoint joinPoint){
        System.out.println("**********后置通知**********");
    }

    public Object inform3(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("**********环绕通知(top)**********");
        Object proceed = joinPoint.proceed();
        System.out.println("**********环绕通知(bottom)**********");
        return proceed;
    }
}
