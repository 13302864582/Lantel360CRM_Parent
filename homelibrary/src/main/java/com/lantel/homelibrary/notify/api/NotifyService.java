package com.lantel.homelibrary.notify.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface NotifyService {
    @GET("broadcasts")
    Observable<NotifyBean> getNotifyData(@HeaderMap Map<String, String> headers, @Query("page") String page, @Query("pagesize") String pagesize);
}
