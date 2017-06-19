package com.sunztech.admin.general_app.model.login;

import com.sunztech.admin.general_app.model.CallBack;

/**
 * Created by jiayazhou on 2017/6/7 0007.
 */

public interface LoginModel {
    void login(String name,String passWord,CallBack callBack);
    void register(String name,String passWord,CallBack callBack);
}
