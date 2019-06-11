package com.lantel.setting.feedback.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface FeedBackService {
    @GET
    Observable<FeedBackBean> feedback(@HeaderMap Map<String, String> headers, @Body FeedBackReqBean reqBean);
}
