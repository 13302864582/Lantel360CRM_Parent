package com.lantel.homelibrary.classreview.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface ClassReviewService {

    @GET("review_students")
    Observable<ClassReviewBean> getClassReviewData(@HeaderMap Map<String, String> headers, @Query("page") String page, @Query("pagesize") String pagesize);
}
