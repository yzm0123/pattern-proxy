package com.gupaoedu.vip.pattern.proxy.dbroute;

public class OrderService implements IOrderService {

    //dao 这些注入的使用，属于静态代理
    private OrderDao orderDao;

    public OrderService(){
        //在spring中应该是自动注入，
        // 为了使用方便，这里在构造方法中直接初始化了
        orderDao = new OrderDao();
    }


    @Override
    public int createOrder(Order order) {
        System.out.println("orderService 调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
