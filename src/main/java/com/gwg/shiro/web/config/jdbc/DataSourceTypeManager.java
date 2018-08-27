package com.gwg.shiro.web.config.jdbc;

public class DataSourceTypeManager {
    private static final ThreadLocal<String> dataSourceTypes = new ThreadLocal<String>(){
        @Override
        protected String initialValue(){
            return DataSourceType.MASTER.getCode();
        }
    };

    public static String get(){
        return dataSourceTypes.get();
    }

    public static void set(String dataSourceType){
        dataSourceTypes.set(dataSourceType);
    }

    public static void reset(){
        dataSourceTypes.set(DataSourceType.MASTER.getCode());
    }
}