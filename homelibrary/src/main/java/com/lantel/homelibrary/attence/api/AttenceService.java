package com.lantel.homelibrary.attence.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
/*Request URL: http://dev.xiao360.com/sapi/student_attendances?int_day=%5BBetween,20190401,20190431%5D&page=1&pagesize=10*/

public interface AttenceService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9d7243e052cde8c3bbecff760b212e29"
    })
    @GET("student_attendances")
    Observable<ResponseBody> getAttenceData(@Query("page") String page, @Query("pagesize") String pagesize);

    @GET("student_attendances?int_day={int_day}")
    Observable<ResponseBody> getAttenceDataRange(@Path("int_day") String int_day, @Query("page") String page, @Query("pagesize") String pagesize);
}
