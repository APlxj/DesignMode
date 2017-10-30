package com.swallow;

import android.util.Log;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public enum Type {
    TYPE1(""),
    TYPE2("枚举类型"),
    TYPE3(""),
    TYPE4(6),
    TYPE5("");

    Type(String s) {
        Log.d("type", s);
    }

    Type(int i) {

    }
}
