package com.lantel.studylibrary.classes.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ClassService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:bdbd550ab300b1212498ce2c7b358aee"
    })
    @GET("classes")
    Observable<ClassBean> getTask(@Query("page") String page, @Query("pagesize")String pagesize);
}
