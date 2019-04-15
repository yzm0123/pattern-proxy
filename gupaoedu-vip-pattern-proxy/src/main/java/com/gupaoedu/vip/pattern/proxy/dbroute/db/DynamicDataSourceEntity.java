package com.gupaoedu.vip.pattern.proxy.dbroute.db;

import java.time.Year;

public class DynamicDataSourceEntity {

    private final static ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    private final static String DEFAULT_SOURCE = null;

    private DynamicDataSourceEntity(){}

    public static String getDataSource(){
        return LOCAL.get();
    }

    /**
     * 假设这里传入的数据源为：
     * DB_2018
     * DB_2019
     * @param dataSource
     */
    public static void setDataSource(String dataSource){
        LOCAL.set(dataSource);
    }

    public static void setDataSource(int year){
        LOCAL.set("DB_" + year);
    }

    public static void resetDataSource (){
        LOCAL.set(DEFAULT_SOURCE);
    }

}
