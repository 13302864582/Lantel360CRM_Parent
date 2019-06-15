package com.lantel.homelibrary.message.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface MessageService {
    @GET("messages")
    Observable<MessageBean> getMessageData(@HeaderMap Map<String, String> headers, @Query("page") String page, @Query("pagesize") String pagesize);
}
