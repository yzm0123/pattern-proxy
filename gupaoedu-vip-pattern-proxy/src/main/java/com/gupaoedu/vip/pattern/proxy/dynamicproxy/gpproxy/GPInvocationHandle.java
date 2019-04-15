package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

public interface GPInvocationHandle {

    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable;
}
