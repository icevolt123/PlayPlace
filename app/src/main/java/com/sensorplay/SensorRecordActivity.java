package com.sensorplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jun on 2018-01-17.
 */

public class SensorRecordActivity extends Activity {

    private int mSensorType;
    private TextView mRecorderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorder_layout);

            Intent intent = getIntent();
            Float data = intent.getFloatExtra("x", 0);

            mRecorderText = (TextView) findViewById(R.id.recordertext);
            mRecorderText.setText(String.valueOf(data));


    }
}