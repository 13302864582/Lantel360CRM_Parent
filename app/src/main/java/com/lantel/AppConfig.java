package com.lantel;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/26
 * Time: 15:50
 */
public class AppConfig {
    /*************************************************** 模块：splash ***************************************************/
    //资源模式
    public static final String RES_MODE = "RES_MODE";

    //获取资源模式，0:本地资源
    public static final int MODE_LOACL = 0;

    //本地资源 int数组
    public static final String LOACL_RES_LIST = "LOACL_RES_LIST";

    //获取资源模式，1:网络资源
    public static final int MODE_NET = 1;

    //网络资源 string集合
    public static final String NET_RES_LIST = "NET_RES_LIST";

   /*************************************************** 模块：我的 ***************************************************/
    /**
     * 布局viewType标志，TYPE_HEAD头布局，TYPE_ITEM选项布局
     */
    public static final int TYPE_HEAD = 0x10;  //头布局
    public static final int TYPE_ITEM = 0x11;  //中间布局
    public static final int TYPE_AD = 0x12;  //结尾布局


    /*************************************************** 模块：主页 ***************************************************/
    //扫一扫的requestcode
    public static final int REQUEST_CODE_SCAN = 100;
}
