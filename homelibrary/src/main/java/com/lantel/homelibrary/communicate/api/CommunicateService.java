package com.lantel.homelibrary.communicate.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface CommunicateService {
    @GET
    Observable<CommunicateBean> getChatData(@HeaderMap Map<String, String> headers,@Url String url);

    @GET
    Observable<CommunicateBean> commitChatData(@HeaderMap Map<String, String> headers,@Url CommitChatReq req);
}
