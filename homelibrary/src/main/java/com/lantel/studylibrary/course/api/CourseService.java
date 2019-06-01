package com.lantel.studylibrary.course.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface CourseService {
    @GET("lessons")
    Observable<CourseBean> getCourseReading(@HeaderMap Map<String, String> headers, @Query("is_learning") String is_learning, @Query("page") String page, @Query("pagesize") String pagesize);
}
