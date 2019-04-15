package com.gupaoedu.vip.pattern.proxy.staticProxy;

import com.gupaoedu.vip.pattern.proxy.Person;

public class Father {

    private Son person;
    public Father(Son son){
        this.person = son;
    }

    public void findLove() {
        System.out.println("父亲开始物色对象。。。");
        this.person.findLove();
        System.out.println("父亲完成任务。。。");
    }
}
