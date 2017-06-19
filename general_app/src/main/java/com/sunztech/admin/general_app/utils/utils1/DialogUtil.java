package com.sunztech.admin.general_app.utils.utils1;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by admin on 2016/10/18.
 */

public class DialogUtil {
    private ProgressDialog pd;

    public DialogUtil( Activity activity) {
        pd = new ProgressDialog(activity);
    }

    public void show(String tishi) {
        pd.setCancelable(true);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage(tishi);
        pd.show();
    }

    public void dismiss() {
        pd.dismiss();
    }
}
