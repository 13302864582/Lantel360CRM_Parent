package com.lantel.mine.wallet.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WalletService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:22f2140a26de8fb9140eabe3e1ff6ff8"
    })
    @GET("students/{sid}/money_history")
    Observable<ResponseBody> getWalletListData(@Path ("sid")String sid, @Query("page") String page, @Query("pagesize") String pagesize);

    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:22f2140a26de8fb9140eabe3e1ff6ff8"
    })
    @GET("students/{sid}/money_history")
    Observable<ResponseBody> getWalletMonthData(@Path ("sid")String sid,@Query("year_month") String year_month,  @Query("page") String page, @Query("pagesize") String pagesize);
}
