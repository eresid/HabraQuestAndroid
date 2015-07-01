package org.dinipra.habraquest.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class SPHelper {
    private Context mContext;
    private String APP_PREFS;

    public SPHelper(Context _context) {
        mContext = _context;
        APP_PREFS = mContext.getPackageName();
    }

    // SAVE TO PREFS

    public void setString(String _key, String _value) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putString(_key, _value);
        prefsEdit.commit();
    }

    public void setInt(String _key, int _value) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putInt(_key, _value);
        prefsEdit.commit();
    }

    public void setLong(String _key, long _value) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putLong(_key, _value);
        prefsEdit.commit();
    }

    public void setFloat(String _key, float _value) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putFloat(_key, _value);
        prefsEdit.commit();
    }

    public void setBoolean(String _key, boolean _value) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putBoolean(_key, _value);
        prefsEdit.commit();
    }

    // GET FROM PREFS

    public String getString(String _key) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        String value = prefs.getString(_key, "");

        return value;
    }

    public String getString(String _key, String _default) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        String value = prefs.getString(_key, _default);

        return value;
    }

    public int getInt(String _key) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        int value = prefs.getInt(_key, 0);

        return value;
    }

    public int getInt(String _key, int _default) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        int value = prefs.getInt(_key, _default);

        return value;
    }

    public long getLong(String _key) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        long value = prefs.getLong(_key, 0);

        return value;
    }

    public long getLong(String _key, long _default) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        long value = prefs.getLong(_key, _default);

        return value;
    }

    public float getFloat(String _key) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        float value = prefs.getFloat(_key, 0);

        return value;
    }

    public float getFloat(String _key, float _default) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        float value = prefs.getFloat(_key, _default);

        return value;
    }

    public boolean getBoolean(String _key) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        boolean value = prefs.getBoolean(_key, false);

        return value;
    }

    public boolean getBoolean(String _key, boolean _default) {
        SharedPreferences prefs = mContext.getSharedPreferences(APP_PREFS, 0);
        boolean value = prefs.getBoolean(_key, _default);

        return value;
    }
}