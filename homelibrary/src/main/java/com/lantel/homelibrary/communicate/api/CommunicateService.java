package com.lantel.homelibrary.communicate.api;

import com.lantel.setting.bindAccount.api.BindAccountBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface CommunicateService {
    @GET
    Observable<CommunicateBean> getChatData(@HeaderMap Map<String, String> headers,@Url String url);

    @POST("im_chats")
    Observable<BindAccountBean> commitChatData(@HeaderMap Map<String, String> headers, @Body CommitChatReq req);
}
