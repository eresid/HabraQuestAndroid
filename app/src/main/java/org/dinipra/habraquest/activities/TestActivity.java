package org.dinipra.habraquest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.widget.DialogTitle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.dinipra.habraquest.R;
import org.dinipra.habraquest.helpers.ProgressHelper;
import org.dinipra.habraquest.models.ApiArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TAG";


    private TextView mTitle;
    private TextView mQuestion;
    private EditText mAnswer;
    private Button mCheckAnswer;

    private ProgressHelper mProgress;
    private ApiArray mApiArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Toolbar toolbar = (Toolbar) findViewById(R.id.test_activity_toolbar);
        toolbar.setTitle("Habra Quest");
        toolbar.setNavigationIcon(R.drawable.ic_launcher);

        setSupportActionBar(toolbar);
        parseJSON();

        mTitle = (TextView) findViewById(R.id.test_activity_title);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("questions_ru.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void parseJSON() {
        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < jsonArray.length(); i++) {
                String value = jsonArray.getString(i);
                JSONObject jsonObject = new JSONObject(value);
                String title = jsonObject.getString("title");
                Log.e(TAG, "title: " + title);
                if (jsonObject.has("question")) {
                    String question = jsonObject.getString("question");
                    Log.e(TAG, "question: " + question);
                }
                String answer = jsonObject.getString("answer");
                Log.e(TAG, "answer: " + answer);
            }

        } catch (JSONException e) {
            Log.e(TAG, "Error  = " + e);
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.test_menu_info:
                Intent intent = new Intent(TestActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}





