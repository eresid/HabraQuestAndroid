package org.dinipra.habraquest.helpers;

import android.util.Log;

public class LoggerHelper {
    private static Boolean SHOW_LOGS = true;

    public static void w(Object _tag, String _msg) {
        if (SHOW_LOGS) {
            Log.w(_tag.getClass().getSimpleName(), _msg);
        }
    }

    public static void i(Object _tag, String _msg) {
        if (SHOW_LOGS) {
            Log.i(_tag.getClass().getSimpleName(), _msg);
        }
    }

    public static void e(Object _tag, String _msg) {
        if (SHOW_LOGS) {
            Log.e(_tag.getClass().getSimpleName(), _msg);
        }
    }

    public static void d(Object _tag, String _msg) {
        if (SHOW_LOGS) {
            Log.d(_tag.getClass().getSimpleName(), _msg);
        }
    }

    public static void v(Object _tag, String _msg) {
        if (SHOW_LOGS) {
            Log.v(_tag.getClass().getSimpleName(), _msg);
        }
    }
}