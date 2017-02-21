package com.paicaifu.app.utils;

import com.sun.istack.internal.Nullable;

/**
 * Created by bayin on 2017/2/21.
 */
public class TextUtils {
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
