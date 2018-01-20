package com.sensorplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jun on 2018-01-19.
 */

public class SensorRecDisplay extends Activity implements Observer {

    private TextView mXaxis;
    private TextView mYaxis;
    private TextView mZaxis;
    private TextView mNano;
    private double mXaxis1;
    private double mYaxis1;
    private double mZaxis1;
    private long mNano1;
    Observable observable;
    SensorManager mSensorManager;
    Sensor mSensor;
    private int mSensorType;
    private SensorListener sensorListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorder_layout);

        mXaxis = (TextView)findViewById(R.id.rec01);
        mYaxis = (TextView)findViewById(R.id.rec02);
        mZaxis = (TextView)findViewById(R.id.rec03);
        mNano = (TextView)findViewById(R.id.nanosec);

       /* Intent intent = getIntent();
        mSensorType = intent.getIntExtra(getResources().getResourceName(R.string.sensor_type), 0);
        mSensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(mSensorType);*/

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorListener = new SensorListener(mSensorManager, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

   /* public SensorRecDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }*/

    @Override
    public void update(Observable observable, Object data) {
        SensorListener sensorListener = (SensorListener) data;
        mNano1 = sensorListener.getTimestamp();
        mXaxis1 = sensorListener.getValueX();
        mYaxis1 = sensorListener.getValueY();
        mZaxis1 = sensorListener.getValueZ();

        mXaxis.setText(String.valueOf(mXaxis1));
        mYaxis.setText(String.valueOf(mYaxis1));
        mZaxis.setText(String.valueOf(mZaxis1));
        mNano.setText(String.valueOf(mNano1));
    }
}