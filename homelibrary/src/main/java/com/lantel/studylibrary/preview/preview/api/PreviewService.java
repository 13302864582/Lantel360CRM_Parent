package com.lantel.studylibrary.preview.preview.api;

import java.util.Map;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PreviewService {
    @GET("course_prepares")
    Observable<PreviewBean> getPrepareData(@HeaderMap Map<String, String> headers,@Query("with") String with,@Query("sid") String sid, @Query("page") String page, @Query("pagesize") String pagesize);

    @GET
    Observable<PreviewDetailBean> getPrepareDetail(@HeaderMap Map<String, String> headers,@Url String url);
}
