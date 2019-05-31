package com.lantel.mine.order.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface OrderService {
    @Headers({
            "x-sid:21",
            "x-sub-host:base",
            "x-token:22f2140a26de8fb9140eabe3e1ff6ff8"
    })
    @GET("orders")
    Observable<OrderBean> getOrderListData(@Query("page") String page, @Query("pagesize") String pagesize);
}
