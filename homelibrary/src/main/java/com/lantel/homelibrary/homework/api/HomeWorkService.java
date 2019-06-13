package com.lantel.homelibrary.homework.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface HomeWorkService {
    @GET("homework_tasks")
    Observable<HomeWorkBean> getHomeWorkDateFinish(@HeaderMap Map<String, String> headers,@Query("page") String page,@Query("pagesize") String pagesize);
}

