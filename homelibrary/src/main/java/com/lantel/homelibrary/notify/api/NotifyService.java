package com.lantel.homelibrary.notify.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NotifyService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:x-token:9d7243e052cde8c3bbecff760b212e29"
    })
    @GET("broadcasts")
    Observable<NotifyBean> getNotifyData(@Query("page") String page, @Query("pagesize") String pagesize);
}
