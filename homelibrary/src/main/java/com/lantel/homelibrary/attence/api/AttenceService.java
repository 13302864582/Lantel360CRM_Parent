package com.lantel.homelibrary.attence.api;

import java.util.Map;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AttenceService {
    @GET("student_attendances")
    Observable<ResponseBody> getAttenceData(@HeaderMap Map<String, String> headers, @Query("page") String page, @Query("pagesize") String pagesize);

    @GET
    Observable<ResponseBody> getAttenceDataRange(@HeaderMap Map<String, String> headers,@Url String url);
}
/*
http://dev.xiao360.com/sapi/student_attendances?int_day=[Between,20190801,20190831]&page=1&pagesize=10
http://dev.xiao360.com/sapi/im_chats?create_time=[<,1561108595657]&page=1&pagesize=20*/
