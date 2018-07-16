package com.asia.library_1.http;

import java.io.IOException;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 11845 on 2018/5/15 0015.
 */

public class OkhttpUtils {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient okHttpClient;
    private static OkhttpUtils mInstance;

    private OkhttpUtils(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public static void init(OkHttpClient okHttpClient){
        mInstance = new OkhttpUtils(okHttpClient);
    }

    public static OkhttpUtils getInstance() {
        if (mInstance == null){
            mInstance = new OkhttpUtils(null);
        }
        return mInstance;
    }

    public static Response post(Map<String,Object> params) throws IOException{
        Request.Builder builder = new Request.Builder();
        //RequestBody body = RequestBody.create(JSON,)
        return mInstance.okHttpClient.newCall(builder.build()).execute();
    }


}
