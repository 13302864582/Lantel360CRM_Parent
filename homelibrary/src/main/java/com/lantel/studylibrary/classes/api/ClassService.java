package com.lantel.studylibrary.classes.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface ClassService {
    @GET("classes")
    Observable<ClassBean> getClassData(@HeaderMap Map<String, String> headers, @Query("page") String page, @Query("pagesize")String pagesize);
}
