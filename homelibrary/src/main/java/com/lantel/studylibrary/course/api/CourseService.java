package com.lantel.studylibrary.course.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CourseService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9d7243e052cde8c3bbecff760b212e29"
    })
    @GET("lessons")
    Observable<CourseBean> getCourseReading(@Query("is_learning") String is_learning,@Query("page") String page, @Query("pagesize") String pagesize);
}
