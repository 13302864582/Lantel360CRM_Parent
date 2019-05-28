package com.lantel.homelibrary.classreview.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ClassReviewService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:9d7243e052cde8c3bbecff760b212e29"
    })
    @GET("review_students")
    Observable<ClassReviewBean> getClassReviewData(@Query("page") String page, @Query("pagesize") String pagesize);
}
