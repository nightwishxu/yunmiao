package com.util.express;

import java.util.*;

/**
 * 快递工具
 */
public class ExpressUtil {
    private static final Map<String,String> map = new HashMap<String, String>();
    static {
        ExpressEnum[] data = ExpressEnum.values();
        for (ExpressEnum expressEnum : data){
            map.put(expressEnum.getName(),expressEnum.getCode());
        }
    }
    private ExpressUtil(){};

    public static Collection<String> getNames(){
        return map.keySet();
    }

    public static String getCodeByName(String name){
        return map.get(name);
    }
}
