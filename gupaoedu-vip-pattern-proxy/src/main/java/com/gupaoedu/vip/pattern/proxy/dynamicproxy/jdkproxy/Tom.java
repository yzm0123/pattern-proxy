package com.gupaoedu.vip.pattern.proxy.dynamicproxy.jdkproxy;

import com.gupaoedu.vip.pattern.proxy.Teacher;

public class Tom implements Teacher {
    @Override
    public void teach() {
        System.out.println("Tom 老师教JAVA课程...");
    }
}
