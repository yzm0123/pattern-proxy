package com.gupaoedu.vip.pattern.proxy.dbroute;

import com.gupaoedu.vip.pattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;
import com.gupaoedu.vip.pattern.proxy.dbroute.proxy.OrderServiceStaticProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbRouteProxyTest {

    public static void main(String[] args) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //静态代理
//            IOrderService orderService = new OrderService();
//            OrderServiceStaticProxy proxy = new OrderServiceStaticProxy(orderService);
//            Order order = new Order();
//            Date date = sdf.parse("2014-01-09");
//            order.setCreateTime(date.getTime());
//            proxy.createOrder(order);

            //动态代理
            OrderServiceDynamicProxy orderServiceDynamicProxy = new OrderServiceDynamicProxy();
            IOrderService orderService = new OrderService();
            IOrderService obj = (IOrderService)orderServiceDynamicProxy.getInstance(orderService);
            Order order = new Order();
            Date date = sdf.parse("2014-01-09");
            order.setCreateTime(date.getTime());
            obj.createOrder(order);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
