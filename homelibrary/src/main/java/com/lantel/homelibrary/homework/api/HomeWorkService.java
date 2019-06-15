package com.lantel.homelibrary.homework.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HomeWorkService {
    @GET("homework_tasks")
    Observable<HomeWorkBean> getHomeWorkDateFinish(@HeaderMap Map<String, String> headers,@Query("page") String page,@Query("pagesize") String pagesize);

    @GET("homework_tasks/{homeworkID}")
    Observable<HomeWorkDetailTaskBean> getHomeWorkDetailTask(@HeaderMap Map<String, String> headers, @Path("homeworkID") String homeworkID);

    @GET("share/homework_complete_detail")
    Observable<HomeWorkDetailFinishBean> getHomeWorkDetailFinish(@HeaderMap Map<String, String> headers, @Query("id") String id);
}

