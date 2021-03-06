package com.sensorplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


public class SensorValuesActivity extends Activity implements SensorEventListener{

	private SensorManager mSensorManager;
	private int mSensorType;
	private Sensor mSensor;
	private TextView mEventValue_0;
	private TextView mEventValue_1;
	private TextView mEventValue_2;
	private TextView mEventValue_3;
	private TextView mEventValue_4;
	private TextView mEventValue_5;
	private TextView mEventValue_6;
	private TextView mTime;
	private TextView mAccuracy;
	ToggleButton btnToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.values_layout);

		Intent intent = getIntent();
		mSensorType = intent.getIntExtra(getResources().getResourceName(R.string.sensor_type), 0);
		mSensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(mSensorType);
		mEventValue_0 = (TextView)findViewById(R.id.event0);
		mEventValue_1 = (TextView)findViewById(R.id.event1);
		mEventValue_2 = (TextView)findViewById(R.id.event2);
		mEventValue_3 = (TextView)findViewById(R.id.event3);
		mEventValue_4 = (TextView)findViewById(R.id.event4);
		mEventValue_5 = (TextView)findViewById(R.id.event5);
		mEventValue_6 = (TextView)findViewById(R.id.event6);
		mTime = (TextView)findViewById(R.id.time);
		mAccuracy = (TextView)findViewById(R.id.accuracy);

        findViewById(R.id.measurerecords).setOnClickListener(btnRec);
        btnToggle = (ToggleButton) this.findViewById(R.id.measuretoggle);
        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked == true) {
                    onPause();
                } else {
                    onResume();
                }
            }
        });
	}

	@Override
	protected void onResume() {
		super.onResume();
//		mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_FASTEST);
		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

/*	protected  void onStop() {
	    super.onStop();
        mSensorManager.unregisterListener(this);
    }*/

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
		public void onSensorChanged(final SensorEvent event) {

		mAccuracy.setText(String.valueOf(event.accuracy));
		mTime.setText("Time: " + String.valueOf(event.timestamp));
		mEventValue_0.setText(String.valueOf(event.values[0]));
		if(event.values.length>1) {
			mEventValue_1.setText(String.valueOf(event.values[1]));
		}
		if(event.values.length>2) {
			mEventValue_2.setText(String.valueOf(event.values[2]));
		}
		if(event.values.length>3) {
			mEventValue_3.setText(String.valueOf(event.values[3]));
		}
		if(event.values.length>4) {
			mEventValue_4.setText(String.valueOf(event.values[4]));
		}
		if(event.values.length>5) {
			mEventValue_5.setText(String.valueOf(event.values[5]));
		}
		if(event.values.length>6) {
			mEventValue_6.setText(String.valueOf(event.values[6]));
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	Button.OnClickListener btnRec = new View.OnClickListener() {

		@Override
		public void onClick(View view) {
			Intent intent = new Intent(SensorValuesActivity.this, SensorRecDisplay.class);
			startActivity(intent);
		}
	};
}
