package org.dinipra.habraquest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.dinipra.habraquest.R;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutActivity extends AppCompatActivity {

    public static final String TAG = AboutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = (Toolbar) findViewById(R.id.about_toolbar);
        toolbar.setTitle("Про програму");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        parseJson();
    }

    private String mJsonExample = "{\n" +
            "\n" +
            "    \"widget\":{\n" +
            "        \"debug\":\"on\",\n" +
            "        \"window\":{\n" +
            "            \"title\":\"Sample Konfabulator Widget\",\n" +
            "            \"name\":\"main_window\",\n" +
            "            \"width\":500,\n" +
            "            \"height\":500\n" +
            "        },\n" +
            "        \"image\":{\n" +
            "            \"src\":\"Images/Sun.png\",\n" +
            "            \"name\":\"sun1\",\n" +
            "            \"hOffset\":250,\n" +
            "            \"vOffset\":250,\n" +
            "            \"alignment\":\"center\"\n" +
            "        },\n" +
            "        \"text\":{\n" +
            "            \"data\":\"Click Here\",\n" +
            "            \"size\":36,\n" +
            "            \"style\":\"bold\",\n" +
            "            \"name\":\"text1\",\n" +
            "            \"hOffset\":250,\n" +
            "            \"vOffset\":100,\n" +
            "            \"alignment\":\"center\",\n" +
            "            \"onMouseUp\":\"sun1.opacity = (sun1.opacity / 100) * 90;\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"id\":145\n" +
            "\n" +
            "}";

    // TODO remove
    private void parseJson() {
        try {
            JSONObject parentObject = new JSONObject(mJsonExample);
            Log.e(TAG, "id = " + parentObject.getInt("id"));
            JSONObject widgetObject = parentObject.getJSONObject("widget");
            Log.e(TAG, "debug = " + widgetObject.getString("debug"));

            JSONObject windowObject = widgetObject.getJSONObject("window");
            Log.e(TAG, "window title = " + windowObject.getString("title"));
            Log.e(TAG, "window width = " + windowObject.getInt("width"));

            JSONObject imageObject = widgetObject.getJSONObject("image");
            Log.e(TAG, "image src = " + imageObject.getString("src"));
            Log.e(TAG, "image alignment = " + imageObject.getString("alignment"));

            JSONObject textObject = widgetObject.getJSONObject("text");
            Log.e(TAG, "text onMouseUp = " + textObject.getString("onMouseUp"));
            Log.e(TAG, "text size = " + textObject.getInt("size"));
        } catch (JSONException e) {
            Log.e(TAG, "Error = " + e);
            e.printStackTrace();
        }
    }
}
