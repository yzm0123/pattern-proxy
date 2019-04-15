package com.gupaoedu.vip.pattern.proxy.dbroute.proxy;

import com.gupaoedu.vip.pattern.proxy.dbroute.IOrderService;
import com.gupaoedu.vip.pattern.proxy.dbroute.Order;
import com.gupaoedu.vip.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用静态代理动态切换数据源
 */
public class OrderServiceStaticProxy implements IOrderService {

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){

        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        long time = order.getCreateTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Integer dbroute = Integer.valueOf(sdf.format(new Date(time)));

        System.out.println("静态代理类自动分配到【DB_" + dbroute+ "】数据源");
        DynamicDataSourceEntity.setDataSource(dbroute);

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.resetDataSource();
        return 0;
    }

}
