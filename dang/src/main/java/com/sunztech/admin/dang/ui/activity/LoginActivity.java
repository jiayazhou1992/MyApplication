package com.sunztech.admin.dang.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sunztech.admin.dang.R;
import com.sunztech.admin.dang.ui.entities.User;
import com.sunztech.admin.dang.ui.utils.utils1.LogUtils;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private EditText editText_uaserName,editText_userPassword;
    private Button button_login;
    private TextView textView_registered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        .setApplicationId("9ae5c5808a52d276e27c3fcdc3038f9d")
        ////请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);

        setContentView(R.layout.activity_login);
        editText_uaserName= (EditText) findViewById(R.id.userName);
        editText_userPassword= (EditText) findViewById(R.id.userPassWord);
        button_login= (Button) findViewById(R.id.login);
        textView_registered= (TextView) findViewById(R.id.registered);

        textView_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user.setName(editText_uaserName.getText().toString());
                user.setPassWord(editText_userPassword.getText().toString());
                user.save(LoginActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        LogUtils.e("LoginActivity","success");
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        LogUtils.e("LoginActivity",i+s);
                    }
                });
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobQuery<User> userBmobQuery=new BmobQuery<User>();
            }
        });

    }
}
