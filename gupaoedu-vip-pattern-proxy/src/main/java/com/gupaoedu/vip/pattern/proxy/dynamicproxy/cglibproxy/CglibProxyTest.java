package com.gupaoedu.vip.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class CglibProxyTest {
    public static void main(String[] args) {
        //这行代码是为了输出代理对象
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"src/main/java/com/gupaoedu/vip/pattern/proxy/dynamicproxy/cglibproxy");
        CglibMeipo cglibMeipo = new CglibMeipo();
        Customer obj  = (Customer) cglibMeipo.getInstance(new Customer().getClass());
        obj.findLove();
    }
}
