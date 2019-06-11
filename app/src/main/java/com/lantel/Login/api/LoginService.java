package com.lantel.Login.api;

import com.lantel.setting.bindAccount.api.SmsBean;
import com.lantel.setting.bindAccount.api.SmsRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LoginService {
    @GET
    Observable<LoginBean> login(@Url String url);

    @Headers({"Domain-Name:x360p_cetner_api"}) // 加上 Domain-Name header
    @POST("/smscode")
    Observable<SmsBean> sendVerifyCode(@Body SmsRequest request);
}
