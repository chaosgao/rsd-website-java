package com.rsd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class UpdateAdvice {

    @Before("execution(* com.rsd.dao.impl.*.insert(..))")
    public void info1(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Class<?> calzz = args[0].getClass();
        Method method;
        try {
             method = calzz.getMethod("setCreateTime", Date.class);
             method.invoke(args[0],new Date());
        } catch (Exception e) {

        }
        try {
            method = calzz.getMethod("setUpdateTime", Date.class);
            method.invoke(args[0],new Date());
        } catch (Exception e) {

        }
    }

    @Before("execution(* com.rsd.dao.impl.*.update(..))")
    public void info2(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Class<?> calzz = args[0].getClass();
        Method method;
        try {
            method = calzz.getMethod("setUpdateTime", Date.class);
            method.invoke(args[0],new Date());
        } catch (Exception e) {

        }
    }
}
