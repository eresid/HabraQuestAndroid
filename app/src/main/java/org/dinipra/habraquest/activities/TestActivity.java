package org.dinipra.habraquest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.dinipra.habraquest.R;
import org.dinipra.habraquest.helpers.ProgressHelper;
import org.dinipra.habraquest.models.ApiArray;

import java.io.IOException;
import java.io.InputStream;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "Tag";


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
    }

    public String loadJSONFromAsset() {
        String json = null;
        InputStream is = null;
        try {
            is = getAssets().open("questions_ru.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                }
            }
        }
        return json;
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





