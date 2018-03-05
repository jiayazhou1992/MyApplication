package com.asia.library_1.utils.utils2;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2016/7/27.
 */
public class FormatUtils {

    /*保留**位数*/
    public static String format(String type,Object object){
        DecimalFormat decimalFormat=new DecimalFormat(type);
        return decimalFormat.format(object);
    }
}
