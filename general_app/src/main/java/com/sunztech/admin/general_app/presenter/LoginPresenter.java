package com.sunztech.admin.general_app.presenter;

import com.sunztech.admin.general_app.model.CallBack;
import com.sunztech.admin.general_app.model.login.LoginModel;
import com.sunztech.admin.general_app.model.login.LoginView;

/**
 * Created by jiayazhou on 2017/6/7 0007.
 */

public class LoginPresenter {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenter(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
    }

    public void login(String name, String passSord){
        loginModel.login(name, passSord, new CallBack() {
            @Override
            public void onSuccess(Object data) {
                loginView.showMessga("成功");
            }

            @Override
            public void onError(String mess, int code) {
                loginView.showMessga("失败");
            }
        });
    }

    public void register(String name, String passSord){
        loginModel.register(name, passSord, new CallBack() {
            @Override
            public void onSuccess(Object data) {
                loginView.showMessga("成功");
            }

            @Override
            public void onError(String mess, int code) {
                loginView.showMessga("失败");
            }
        });
    }
}
