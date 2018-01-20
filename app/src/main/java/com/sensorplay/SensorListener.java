package com.sensorplay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jun on 2018-01-19.
 */

public class SensorListener extends Observable implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private double mEventValue_0;
    private double mEventValue_1;
    private double mEventValue_2;
    private TextView mEventValue_3;
    private TextView mEventValue_4;
    private TextView mEventValue_5;
    private TextView mEventValue_6;
    private long mTime;
    private TextView mAccuracy;
    Observable observable;
    private SensorRecDisplay sensorRecDisplay;

    public SensorListener(SensorManager service, Observer o) {
        this(service);
        addObserver(o);
    }

    public SensorListener (SensorManager service) {
        mSensorManager = service;
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ALL);
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public SensorListener(long mTime, double mEventValue_0, double mEventValue_1, double mEventValue_2) {
        this.mTime = mTime;
        this.mEventValue_0 = mEventValue_0;
        this.mEventValue_1 = mEventValue_1;
        this.mEventValue_2 = mEventValue_2;
    }

    @Override
    public void onSensorChanged(final SensorEvent event) {

       /* mAccuracy.setText(String.valueOf(event.accuracy));
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
        }*/

/*        SensorListener data = new SensorListener(mTime, event.values[0],
                event.values[1], event.values[2] );*/
        long mTime = event.timestamp;
        double mEventValue_0 = event.values[0];
        double mEventValue_1 = event.values[1];
        double mEventValue_2 = event.values[2];


        SensorListener data = new SensorListener(mTime, mEventValue_0,
                mEventValue_1, mEventValue_2);
        this.setChanged();
        this.notifyObservers(data);
    }

    public long getTimestamp() {
        return SensorListener.this.mTime;
    }

    public double getValueX() {
        return mEventValue_0;
    }

    public double getValueY() {
        return mEventValue_1;
    }

    public double getValueZ() {
        return mEventValue_2;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int Accuracy) {

    }
}
