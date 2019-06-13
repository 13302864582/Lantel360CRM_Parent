package com.lantel;

import android.util.Log;

import com.excellence.downloader.Downloader;
import com.httpsdk.http.CacheInterceptor;
import com.httpsdk.http.Constans;
import com.httpsdk.http.Http;
import com.httpsdk.http.LogInterceptor;
import com.lantel.common.ClassRoom;
import com.lantel.common.SchoolArea;
import com.mob.MobSDK;
import com.tencent.smtt.sdk.QbSdk;
import com.xiao360.baselibrary.base.BaseApplication;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.SpCache;
import com.zzhoujay.richtext.RichText;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class MyApplication extends BaseApplication {
    List<ClassRoom> classRoom;
    List<SchoolArea> schoolAreas;
    private List<BaseModel> leaveTypes;

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

    public void setLeaveTypes(List<BaseModel> leaveTypes) {
        this.leaveTypes = leaveTypes;
    }

    public List<BaseModel> getLeaveTypes() {
        return leaveTypes;
    }

    @Override
    protected void onCreateSelf() {
        Downloader.init(this);
        File cacheDir = new File(getAppContext().getCacheDir(), "response");
        //缓存的最大尺寸10m
        Cache cache = new Cache(cacheDir, 1024 * 1024 * 10);
        RichText.initCacheDir(getAppContext());
        OkHttpClient.Builder builder =  new OkHttpClient.Builder()
               .cache(cache).readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(Constans.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new LogInterceptor())//添加打印拦截器
                .addInterceptor(new CacheInterceptor(getAppContext()))
                .retryOnConnectionFailure(true); //设置出现错误进行重新连接;*/
        Http.init(builder, Constans.baseUrl);
        SpCache.init(this);
        MobSDK.init(this);

        //初始化X5内核
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。
            }
            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("@@","加载内核是否成功:"+b);
            }
        });
    }
}
