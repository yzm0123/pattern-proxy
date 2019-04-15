package com.gupaoedu.vip.pattern.proxy.dbroute.proxy;

import com.gupaoedu.vip.pattern.proxy.dbroute.IOrderService;
import com.gupaoedu.vip.pattern.proxy.dbroute.Order;
import com.gupaoedu.vip.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用静态代理动态切换数据源
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object proxyObj;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    public Object getInstance(Object proxyObj){

        this.proxyObj = proxyObj;
        Class clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(proxyObj,args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("proxy after method...");
        DynamicDataSourceEntity.resetDataSource();
    }

    //target 应该是订单对象Order
    private void before(Object target) {
        try {
            System.out.println("proxy before method...");
            //这里 约定由于配置
            long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbroute = Integer.valueOf(sdf.format(new Date(time)));

            System.out.println("静态代理类自动分配到【DB_" + dbroute+ "】数据源");
            DynamicDataSourceEntity.setDataSource(dbroute);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
