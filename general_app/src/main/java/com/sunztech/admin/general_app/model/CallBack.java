package com.sunztech.admin.general_app.model;

/**
 * Created by jiayazhou on 2017/6/2 0002.
 */

public interface CallBack<T> {

    void onSuccess(T data);
    void onError(String mess,int code);
}
