package com.lantel.setting.bindfile.bindstudent.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

public interface BindStudentService {
    @GET("students")
    Observable<BindStudentBean> getAccountData(@HeaderMap Map<String, String> headers, @Query("uid") String uid);
}
