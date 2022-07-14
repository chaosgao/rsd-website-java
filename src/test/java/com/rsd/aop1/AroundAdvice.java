package com.rsd.aop1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("··········环绕通知(头)··········");
        Object proceed = invocation.proceed();
        System.out.println("··········环绕通知(尾)··········");
        return proceed;
    }
}
