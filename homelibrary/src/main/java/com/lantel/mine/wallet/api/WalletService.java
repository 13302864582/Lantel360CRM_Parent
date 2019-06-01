package com.lantel.mine.wallet.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WalletService {
    @GET("students/{sid}/money_history")
    Observable<ResponseBody> getWalletListData(@HeaderMap Map<String, String> headers,@Path ("sid")String sid, @Query("page") String page, @Query("pagesize") String pagesize);


    @GET("students/{sid}/money_history")
    Observable<ResponseBody> getWalletMonthData(@HeaderMap Map<String, String> headers, @Path ("sid")String sid, @Query("year_month") String year_month, @Query("page") String page, @Query("pagesize") String pagesize);
}
