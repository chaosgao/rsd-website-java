package com.gc.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.lang.reflect.Method;
import java.util.Date;

@Intercepts(@Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class}))
public class UpdateInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        if (args.length == 2){
            Object arg1 = args[0];
            MappedStatement ms = (MappedStatement)arg1;
            if (ms.getSqlCommandType() == SqlCommandType.INSERT){
                Object arg = args[1];
                Class clazz = arg.getClass();
                try {
                    Method method = clazz.getMethod("setCreateTime",Date.class);
                    method.invoke(arg,new Date());
                }catch (NoSuchMethodException e){

                }
                try {
                    Method method = clazz.getMethod("setBirthTime",Date.class);
                    method.invoke(arg,new Date());
                }catch (NoSuchMethodException e){

                }
                try {
                    Method method = clazz.getMethod("setUpdateTime",Date.class);
                    method.invoke(arg,new Date());
                }catch (NoSuchMethodException e){

                }
            }
            if (ms.getSqlCommandType() == SqlCommandType.UPDATE){
                Object arg = args[1];
                Class clazz = arg.getClass();
                try {
                    Method method = clazz.getMethod("setUpdateTime",Date.class);
                    method.invoke(arg,new Date());
                }catch (NoSuchMethodException e){

                }
                try {
                    Method method = clazz.getMethod("setCreateTime",Date.class);
                    method.invoke(arg,new Date());
                }catch (NoSuchMethodException e){

                }
            }
        }
        return invocation.proceed();
    }
}
