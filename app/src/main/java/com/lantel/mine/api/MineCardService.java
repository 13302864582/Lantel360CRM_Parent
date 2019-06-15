package com.lantel.mine.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface MineCardService {
    @GET("students")
    Observable<MineCardBean> getCardData(@HeaderMap Map<String, String> headers,@Query("uid") String uid);

    @GET("users/switch_sid")
    Observable<MineCardBean> changeAccount(@HeaderMap Map<String, String> headers,@Query("uid") String uid,@Query("sid") String sid);
}
