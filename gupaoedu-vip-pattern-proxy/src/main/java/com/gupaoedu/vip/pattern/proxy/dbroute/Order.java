package com.gupaoedu.vip.pattern.proxy.dbroute;

public class Order {
    private Object oderInfo;
    //按订单的创建时间进行分库
    private long createTime;
    private String id;

    public Object getOderInfo() {
        return oderInfo;
    }

    public void setOderInfo(Object oderInfo) {
        this.oderInfo = oderInfo;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
