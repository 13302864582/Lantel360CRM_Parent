package com.lantel.homelibrary.attence.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AttenceService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9a3a393f8ea863c036cfd84fa38bff32"
    })
    @GET("student_attendances")
    Observable<ResponseBody> getAttenceData(@Query("page") String page, @Query("pagesize") String pagesize);

    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9a3a393f8ea863c036cfd84fa38bff32"
    })
    @GET
    Observable<ResponseBody> getAttenceDataRange(@Url String url);
}
