package org.dinipra.habraquest.models;

import org.json.JSONArray;


    public class ApiArray extends ApiObject {

        public ApiArray(JSONArray array) {
            super(array);
        }

        public String getTitle(int _position) {
            String value = "";

            try {
                value = mData.getJSONObject(_position).getString("title");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return value;
        }

        public String getQuestion(int _position) {
            String value = "";

            try {
                value = mData.getJSONObject(_position).getString("question");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return value;
        }

        public String getAnswer(int _position) {
            String value = "";

            try {
                value = mData.getJSONObject(_position).getString("answer");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return value;
        }
    }
