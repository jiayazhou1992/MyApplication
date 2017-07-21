package com.sunztech.admin.dang.ui.utils.utils1;

import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/4/26.
 */
public class PopupWindowUtil {
    public static void setPopupWindowTouchModal(PopupWindow popupWindow,
                                                boolean touchModal) {
        if (null == popupWindow) {
            return;
        }
        Method method;
        try {

            method = PopupWindow.class.getDeclaredMethod("setTouchModal",
                    boolean.class);
            method.setAccessible(true);
            method.invoke(popupWindow, touchModal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //v=1f恢复
    public static void setWindowBackground(AppCompatActivity activity,float v){
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = v;
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setAttributes(lp);
    }

}
