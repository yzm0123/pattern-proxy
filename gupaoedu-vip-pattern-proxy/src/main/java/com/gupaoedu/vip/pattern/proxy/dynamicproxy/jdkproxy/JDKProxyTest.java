package com.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy;

import com.gupaoedu.vip.pattern.proxy.Person;
import com.gupaoedu.vip.pattern.proxy.Teacher;
import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.Method;

public class JDKProxyTest {
    public static void main(String[] args) {

        try {
            JDKMeipo jdkProxy = new JDKMeipo();

            /**
             * girl的需求通过媒婆动态代理
             */
//            Person person = new Girl();
//            Person o = (Person)jdkProxy.getInstance(person);
//            o.findLove();
//
//            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
//            FileOutputStream fos = new FileOutputStream("src/main/java/com/gupaoedu/vip/pattern/proxy/dynamicproxy/jdkproxy/$Proxy0.class");
//            fos.write(bytes);
//            fos.close();

            /**
             * 这里验证被代理对象需要实现接口，才能用动态代理
             */
//            Boy boy = new Boy();
//            Object obj = jdkProxy.getInstance(boy);
//            Method m = obj.getClass().getMethod("findLove",null);
//            m.invoke(obj,null);

            /**
             * 从$Proxy0.class反编译文件中看出，$Proxy0 implements 类Boy了
             * public final class $Proxy0 extends Proxy implements Boy
             */
            Boy boy1 = new Boy();
            jdkProxy.getInstance(boy1);
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Boy.class});
            FileOutputStream fos = new FileOutputStream("src/main/java/com/gupaoedu/vip/pattern/proxy/dynamicproxy/jdkproxy/$Proxy0.class");
            fos.write(bytes);
            fos.close();


//            Teacher teacher = new Tom();
//            Teacher o2 = (Teacher) jdkProxy.getInstance(teacher);
//            o2.teach();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
