package com.sunztech.admin.general_app.widget.refreshload;

import android.view.View;

/**
 * Created by jiayazhou on 2017/11/9.
 */

public interface RefreshFoot {
    View getFoot();
    int getHight();
    int getWidth();
    void load();
    void loadComplete();
    void scrollLisenter(int dy);
    int pullUp(int dy);
    boolean isBottleneck();
    boolean isLive();
    int getFixType();
}
