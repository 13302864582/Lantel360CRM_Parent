package com.lantel.Login.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LoginService {
    @GET
    Observable<LoginBean> login(@Url String url);

    @GET("logout")
    Observable<LogoutBean> logout(@HeaderMap Map<String, String> headers);

    @GET("open/vcode")
    Observable<LogoutBean> sendVerifyUnlogin(@Body VerifyUnloginReq req);

    @Headers({"Domain-Name:x360p_cetner_api"}) // 加上 Domain-Name header
    @POST("/smscode")
    Observable<LoginVerifyBean> sendVerifyCode(@Body LoginVerifyReq request);

    @Headers({"Domain-Name:x360p_cetner_api"}) // 加上 Domain-Name header
    @POST("/signup")
    Observable<RegsistBean> signup(@Body SignUpReq request);

    @Headers({"Domain-Name:x360p_cetner_api"}) // 加上 Domain-Name header
    @POST("/user/resetpwd")
    Observable<RsetBean> userresetpwd(@Body UserRsetReq request);

    @Headers({"Domain-Name:x360p_cetner_api"}) // 加上 Domain-Name header
    @POST("/smscode")
    Observable<RsetBean> resetpwd(@Body RsetReq request);
}
