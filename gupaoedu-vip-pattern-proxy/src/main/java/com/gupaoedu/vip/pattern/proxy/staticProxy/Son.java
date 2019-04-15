package com.gupaoedu.vip.pattern.proxy.staticProxy;

import com.gupaoedu.vip.pattern.proxy.Person;

public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("son 的要求：白富美！");
    }
}
