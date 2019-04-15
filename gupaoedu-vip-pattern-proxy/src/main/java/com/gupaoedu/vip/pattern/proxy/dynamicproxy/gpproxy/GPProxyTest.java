package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;

import com.gupaoedu.vip.pattern.proxy.Person;
import com.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy.Girl;

public class GPProxyTest {
    public static void main(String[] args) {
        GPMeipo gpProxy = new GPMeipo();

        Person person = new Girl();
        Person o = (Person)gpProxy.getInstance(person);
        o.findLove();

    }
}
