package com.lantel.setting.editPassword;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ChangPwdService {
    @POST("users/edit_profile")
    Observable<ChangPwdBean> resetpwd(@HeaderMap Map<String, String> headers, @Body ChangpwdReq request);
}
