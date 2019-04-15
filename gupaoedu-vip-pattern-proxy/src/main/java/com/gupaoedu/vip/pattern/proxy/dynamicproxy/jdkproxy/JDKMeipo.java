package com.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy;

import com.gupaoedu.vip.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理，需要实现InvocationHandler接口
 * 这里JDKMeipo 是代理对象，Girl是被代理对象
 */
public class JDKMeipo implements InvocationHandler {

    private Object target;//被代理的目标对象

    public Object getInstance(Object person){
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("JDKMeipo调用目标对象的方法之前，执行before。。。");
    }

    private void after(){
        System.out.println("JDKMeipo调用目标对象的方法之后，执行after...");
    }
}
