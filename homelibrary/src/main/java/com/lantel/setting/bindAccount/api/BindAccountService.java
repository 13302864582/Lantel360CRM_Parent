package com.lantel.setting.bindAccount.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface BindAccountService {
    @POST("users/edit_profile")
    Observable<BindPhoneBean> bindPhoto(@HeaderMap Map<String, String> headers, @Body BindPhoneReqBean bindPhoneReqBean);

    @POST("open/vcode")
    Observable<SmsBean> sendVerifyCode(@Body SmsRequest request);
}
