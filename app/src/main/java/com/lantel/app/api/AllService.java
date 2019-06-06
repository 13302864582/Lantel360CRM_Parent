package com.lantel.app.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface AllService {
    @GET("global/all")
    Observable<AllBean> getGlobleData(@HeaderMap Map<String, String> headers);
}
