package com.lantel.mine.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface MineCardService {
    @Headers({
            "x-sid:23",
            "x-sub-host:base",
            "x-token:22f2140a26de8fb9140eabe3e1ff6ff8"
    })
    @GET("students")
    Observable<MineCardBean> getCardData(@Query("uid") String uid);
}
