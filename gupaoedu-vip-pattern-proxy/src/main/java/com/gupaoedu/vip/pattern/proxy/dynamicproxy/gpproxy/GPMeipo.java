package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;

import com.gupaoedu.vip.pattern.proxy.Person;

import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandle {

    private Object target;

    public Object getInstance(Object obj){
        this.target = obj;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this::invoke);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{
        before();
        Object obj = method.invoke(target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("GPMeipo调用目标对象的方法之前，执行before。。。");
    }

    private void after(){
        System.out.println("GPMeipo调用目标对象的方法之后，执行after。。。");
    }
}
