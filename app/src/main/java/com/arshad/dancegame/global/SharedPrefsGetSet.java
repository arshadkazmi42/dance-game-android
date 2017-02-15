package com.arshad.dancegame.global;

import android.content.Context;
import android.util.Log;

public class SharedPrefsGetSet {

    public static final String KEY_APP_VERSION = "appVersion";
    public static final String KEY_RANDOM = "random";
    public static final String KEY_N_VALUE = "nvalue";
    public static final String KEY_COUNT = "count";

    /**
     * Getting GCM ID
     * @param mContext
     * @return
     */
    public static int getAppVersion(Context mContext) {
        return GlobalFunctions.getSharedPrefs(mContext, KEY_APP_VERSION, 0);
    }

    public static void setRandom(Context mContext, int random) {
        GlobalFunctions.setSharedPrefs(mContext, KEY_RANDOM, random);
    }

    public static int getRandom(Context mContext) {
        return GlobalFunctions.getSharedPrefs(mContext, KEY_RANDOM, 0);
    }

    public static void setNValue(Context mContext, int n) {
        Log.e("N", n+ " ");
        GlobalFunctions.setSharedPrefs(mContext, KEY_N_VALUE, n);
    }

    public static int getNValue(Context mContext) {
        return GlobalFunctions.getSharedPrefs(mContext, KEY_N_VALUE, 0);
    }

    public static int getCount(Context mContext) {
        return GlobalFunctions.getSharedPrefs(mContext, KEY_COUNT, 0);
    }

    public static void setCount(Context mContext, int count) {
        GlobalFunctions.setSharedPrefs(mContext, KEY_COUNT, count);
    }

}
