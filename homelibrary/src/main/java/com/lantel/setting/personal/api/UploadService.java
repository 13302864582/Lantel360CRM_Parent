package com.lantel.setting.personal.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface UploadService {
    @GET
    Observable<UploadBean> getUploadData(@HeaderMap Map<String, String> headers, @Url String url);

    @PUT("students")
    Observable<UploadResultBean> commitUpload(@HeaderMap Map<String, String> headers,@Body UploadReq req);
}
