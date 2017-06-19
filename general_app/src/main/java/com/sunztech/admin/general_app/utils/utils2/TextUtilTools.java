package com.sunztech.admin.general_app.utils.utils2;


import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 刘大军 on 2015/12/24.
 */
public class TextUtilTools {

    /**
     * 关键字高亮显示
     *
     * @param key  需要高亮的关键字
     * @param text 需要显示的文字
     * @return spannable 处理完后的结果，记得不要toString()，否则没有效果
     */
    public static SpannableStringBuilder highlight(Context context,int color,String text, String key) {
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        CharacterStyle span = null;

        Pattern p = Pattern.compile(key);
        Matcher m = p.matcher(text);
        while (m.find()) {
            span = new ForegroundColorSpan(context.getResources().getColor(color));// 需要重复！
            spannable.setSpan(span, m.start(), m.end(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spannable;
    }

    /**
     * @author 刘大军
     * created at
     * 只允许字母和数字   String   regEx  =  "[^a-zA-Z0-9]"
     */
//    清除掉所有特殊字符
    public static String stringContent(String text, String key) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& amp;*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);
        return m.replaceAll("").trim();
    }

    public static String stringRegexContent(String text){
        String regex="[\n|\r|\t|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        return m.replaceAll("").trim();
    }
}