package com.codesniper.codedebugger.utils;

import android.util.Log;

import com.codesniper.codedebugger.BuildConfig;



public class LogHelper {
    private static final boolean DEBUG = BuildConfig.DEBUG;
    private static final String TAG = "Doraemon";

    public static void d(String subTag, String msg) {
        if (DEBUG) {
            Log.d(TAG, "[" + subTag + "]: " + msg);
        }
    }

    public static void i(String subTag, String msg) {
        if (DEBUG) {
            Log.i(TAG, "[" + subTag + "]: " + msg);
        }
    }

    public static void e(String subTag, String msg) {
        if (DEBUG) {
            Log.e(TAG, "[" + subTag + "]: " + msg);
        }
    }
}
