package com.lantel.home.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface HomeService {
    @GET("index/homecfg")
    Observable<HomeBean> getHomeData(@HeaderMap Map<String, String> headers);


    @GET("notices/num")
    Observable<HomeMessageBean> getMessageData(@HeaderMap Map<String, String> headers);
}
