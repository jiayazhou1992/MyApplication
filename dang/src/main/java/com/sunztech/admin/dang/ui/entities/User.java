package com.sunztech.admin.dang.ui.entities;

import cn.bmob.v3.BmobObject;

/**
 * Created by jiayazhou on 2017/7/19 0019.
 */

public class User extends BmobObject {

    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
