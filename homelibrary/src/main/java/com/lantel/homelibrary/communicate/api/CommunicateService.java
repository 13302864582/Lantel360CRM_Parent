package com.lantel.homelibrary.communicate.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface CommunicateService {
    @GET("students")
    Observable<CommunicateBean> getStudentData(@HeaderMap Map<String, String> headers, @Query("uid") String uid);
}
