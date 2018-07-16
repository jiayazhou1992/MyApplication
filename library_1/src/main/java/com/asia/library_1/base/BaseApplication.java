package com.asia.library_1.base;

import android.app.Application;

import com.asia.library_1.http.OkhttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by jiayazhou on 2017/2/27 0027.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient client = new OkHttpClient();
        client.newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        OkhttpUtils.init(client);
    }
}
