package com.lantel.common;

import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.util.SpCache;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {
    public static Map<String,String> getHeaderMap(){
        Map<String,String> map = new HashMap<>();
        map.put("x-sid", SpCache.getString(Config.SID,""));
        map.put("x-sub-host", SpCache.getString(Config.X_SUB_HOST,""));
        map.put("x-token", SpCache.getString(Config.TOKEN,""));
        return map;
    }

    public static Map<String,String> getJsonHeaderMap(){
        Map<String,String> map = new HashMap<>();
        map.put("x-sid", SpCache.getString(Config.SID,""));
        map.put("x-sub-host", SpCache.getString(Config.X_SUB_HOST,""));
        map.put("x-token", SpCache.getString(Config.TOKEN,""));
        map.put("Content-Type","application/json");
        return map;
    }
}
