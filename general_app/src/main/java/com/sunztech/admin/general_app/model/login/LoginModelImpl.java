package com.sunztech.admin.general_app.model.login;

import android.util.Log;

import com.sunztech.admin.general_app.model.CallBack;
import com.sunztech.admin.general_app.utils.utils1.LogUtils;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jiayazhou on 2017/6/7 0007.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(String name, String passWord, final CallBack callBack) {
        final OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody formbody=new FormBody.Builder()
                .add("id",name)
                .add("password",passWord)
                .build();
        final Request request=new Request.Builder()
                .post(formbody)
                .url("http://172.16.1.29:8080/hello_web/LoginServlet")
                .build();

        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Response response=okHttpClient.newCall(request).execute();
                    int code=response.code();
                    LogUtils.v(code);
                    if (code!=200){
                        subscriber.onError(new Throwable("网络错误"));
                    }else {
                        subscriber.onNext(response.body().string().toString());

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        });

        Observer<String> observer=new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("login","完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("login","错误");
                callBack.onError(e.getMessage(),0);
            }

            @Override
            public void onNext(String s) {
                Log.e("login","成功"+s);
                callBack.onSuccess(null);
            }
        };

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void register(String name, String passWord, final CallBack callBack) {
        final OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody formbody=new FormBody.Builder()
                .add("name",name)
                .add("password",passWord)
                .build();
        final Request request=new Request.Builder()
                .post(formbody)
                .url("http://172.16.1.29:8080/hello_web/RegisterServlrt")
                .build();

        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Response response=okHttpClient.newCall(request).execute();
                    int code=response.code();
                    LogUtils.v(code);
                    if (code!=200){
                        subscriber.onError(new Throwable("网络错误"));
                    }else {
                        subscriber.onNext(response.body().string().toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
                subscriber.onCompleted();
            }
        });

        Observer<String> observer=new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("login","完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("login","错误");
                callBack.onError(e.getMessage(),0);
            }

            @Override
            public void onNext(String s) {
                Log.e("login","成功"+s);
                callBack.onSuccess(null);
            }
        };

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
