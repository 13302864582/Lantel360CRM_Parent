package com.lantel.homelibrary.output.api;

import com.lantel.homelibrary.course.calendar.CalenderSchemBean;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;


public interface OutputService {
    @GET("course_arranges/get_course_day")
    Observable<CalenderSchemBean> getSchmeDate(@HeaderMap Map<String, String> headers, @Query("with") String with,@Query("page") String page,@Query("pagesize") String pagesize);
}

