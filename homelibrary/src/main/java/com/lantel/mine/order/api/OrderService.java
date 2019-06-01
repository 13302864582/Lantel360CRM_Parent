package com.lantel.mine.order.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface OrderService {
    @GET("orders")
    Observable<OrderBean> getOrderListData(@HeaderMap Map<String, String> headers, @Query("page") String page, @Query("pagesize") String pagesize);
}
