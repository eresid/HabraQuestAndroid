package org.dinipra.habraquest.models;

import org.json.JSONArray;

public class ApiObject {
    protected JSONArray mData;

    public ApiObject() {
        mData = null;
    }

    public ApiObject(JSONArray _data) {
        try {
            mData = _data;
        } catch (Exception e) {
            e.printStackTrace();
            mData = null;
        }
    }

    public String toString() {
        return mData.toString();
    }
}
