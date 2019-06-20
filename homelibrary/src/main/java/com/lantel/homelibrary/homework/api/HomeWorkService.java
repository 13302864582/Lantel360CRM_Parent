package com.lantel.homelibrary.homework.api;

import com.lantel.setting.bindAccount.api.BindAccountBean;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface HomeWorkService {
    @GET("homework_tasks/{sid}/homework_tasks")
    Observable<HomeWorkBean> getHomeWorkDate(@HeaderMap Map<String, String> headers,@Path("sid") String sid,@Query("page") String page,@Query("pagesize") String pagesize);

    @GET("homework_tasks/{homeworkID}")
    Observable<HomeWorkDetailFinishBean> getHomeWorkDetail(@HeaderMap Map<String, String> headers,@Path(value = "homeworkID") String homeworkID);

    @POST("homework_tasks/{h_id}/homework_complete")
    Observable<BindAccountBean> uploadHomeWork(@HeaderMap Map<String, String> headers, @Path("h_id")String h_id, @Body CommitHomeReq commitHomeReq);

    @POST
    Observable<UploadResponeBean> uploadAttachFile(@HeaderMap Map<String, String> headers, @Url String url,@Body UpLoadAttach attach);
}

