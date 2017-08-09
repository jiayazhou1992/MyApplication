package com.sunztech.admin.general_app.ui.activity;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.FitWindowsLinearLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.base.BaseActivity;
import com.sunztech.admin.general_app.model.login.LoginModelImpl;
import com.sunztech.admin.general_app.model.login.LoginView;
import com.sunztech.admin.general_app.presenter.LoginPresenter;
import com.sunztech.admin.general_app.utils.utils1.LogUtils;


public class LoginActivity extends BaseActivity implements LoginView{

    private Button view_login;
    private TextView textView_register;
    private EditText editText_id,editText_password;
    private LoginPresenter loginPresenter;
    private FitWindowsLinearLayout fitWindowsLinearLayout;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        LogUtils.getBuilder().create();
        loginPresenter=new LoginPresenter(new LoginModelImpl(),this);
    }

    @Override
    protected void initFindViewById() {
        super.initFindViewById();
        view_login= (Button) findViewById(R.id.textview_login);
        textView_register= (TextView) findViewById(R.id.textview_register);
        editText_id= (EditText) findViewById(R.id.edit_id);
        editText_password= (EditText) findViewById(R.id.edit_password);
        fitWindowsLinearLayout= (FitWindowsLinearLayout) findViewById(R.id.activity_main_FitSystemWindowsLinearLayout);

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        view_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //loginPresenter.login(editText_id.getText().toString(),editText_password.getText().toString());
                showMessga("成功");
            }
        });
        textView_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.register(editText_id.getText().toString(),editText_password.getText().toString());
            }
        });
    }

    @Override
    protected void initView() {

    }


    @Override
    public void showMessga(String messga) {
        toast(messga);
        if (messga.equals("成功")){
            Intent intent=new Intent(this,ListActivity.class);
            startActivity(intent);
        }
    }
}
