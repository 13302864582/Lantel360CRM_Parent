package com.lantel.homelibrary.output.api;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Url;


public interface OutputService {
    @GET
    Observable<OutputBean> getArtWorkDate(@HeaderMap Map<String, String> headers, @Url String url);
}

