package com.gupaoedu.vip.pattern.proxy.staticProxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        //这里 父亲只会给自己的儿子找对象，所以Father会持有Son的引用去执行方法
        //这就是静态代理
        Father father = new Father(new Son());
        father.findLove();

    }
}
