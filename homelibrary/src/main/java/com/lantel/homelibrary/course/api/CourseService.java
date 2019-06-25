package com.lantel.homelibrary.course.api;

import com.lantel.homelibrary.course.calendar.CalenderSchemBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface CourseService {
    @GET("course_arranges/get_course_day")
    Observable<CalenderSchemBean> getSchmeDate(@HeaderMap Map<String, String> headers,@Query("pagesize") String pagesize);


    @GET
    Observable<CourseBean> getCourseData(@HeaderMap Map<String, String> headers, @Url String url);
}

