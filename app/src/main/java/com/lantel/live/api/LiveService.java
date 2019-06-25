package com.lantel.live.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface LiveService {
    @GET("lessons")
    Observable<LiveBean> getLiveData(@HeaderMap Map<String, String> headers, @Query("is_learning") String is_learning, @Query("is_online") String is_online, @Query("page") String page, @Query("pagesize") String pagesize);
}
