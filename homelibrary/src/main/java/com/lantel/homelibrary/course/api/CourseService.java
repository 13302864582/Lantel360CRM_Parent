package com.lantel.homelibrary.course.api;

import com.lantel.homelibrary.course.calendar.CalenderSchemBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface CourseService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9d7243e052cde8c3bbecff760b212e29"
    })
    @GET("course_arranges/get_course_day")
    Observable<CalenderSchemBean> getSchmeDate(@Query("pagesize") String pagesize);

    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9d7243e052cde8c3bbecff760b212e29"
    })
    @GET
    Observable<CourseBean> getCourseData(@Url String url);
}

