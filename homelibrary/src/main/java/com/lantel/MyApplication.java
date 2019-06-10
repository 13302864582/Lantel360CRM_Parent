package com.lantel;

import com.excellence.downloader.Downloader;
import com.httpsdk.http.CacheInterceptor;
import com.httpsdk.http.Constans;
import com.httpsdk.http.Http;
import com.httpsdk.http.LogInterceptor;
import com.lantel.common.ClassRoom;
import com.lantel.common.SchoolArea;
import com.xiao360.baselibrary.base.BaseApplication;
import com.xiao360.baselibrary.util.SpCache;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class MyApplication extends BaseApplication {
    List<ClassRoom> classRoom;
    List<SchoolArea> schoolAreas;

    public List<SchoolArea> getSchoolAreas() {
        return schoolAreas;
    }

    public void setSchoolAreas(List<SchoolArea> schoolAreas) {
        this.schoolAreas = schoolAreas;
    }

    public List<ClassRoom> getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(List<ClassRoom> classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    protected void onCreateSelf() {
        Downloader.init(this);
        File cacheDir = new File(getAppContext().getCacheDir(), "response");
        //缓存的最大尺寸10m
        Cache cache = new Cache(cacheDir, 1024 * 1024 * 10);

        OkHttpClient.Builder builder =  new OkHttpClient.Builder()
               .cache(cache).readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(Constans.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new LogInterceptor())//添加打印拦截器
                .addInterceptor(new CacheInterceptor(getAppContext()))
                .retryOnConnectionFailure(true); //设置出现错误进行重新连接;*/
        Http.init(builder, Constans.baseUrl);
        SpCache.init(this);
    }
}
