package com.lantel.Login.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface LoginService {
    @GET
    Observable<LoginBean> login(@Url String url);
}
