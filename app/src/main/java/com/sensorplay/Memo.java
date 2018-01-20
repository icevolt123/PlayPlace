package com.sensorplay;

import android.hardware.SensorManager;

/**
 * Created by Jun on 2018-01-21.
 */

public interface Memo {}

/*    * 지자기 센서가 있는지 체크
    private SensorManager mSensorManager;
    ...
    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {

            } else {

            }*/

/*    private SensorManager mSensorManager;
    private Sensor mSensor;
    ...
    mSensorManager = (SensorManager) getSystemService (Context.SENSOR_SERVICE);
    if (mSensorManager.getDefaultSensor (Sensor.TYPE_GRAVITY) != null) {
        List<Sensor> gravSensors = mSensorManager.getSensorList(Sensor.TYPE_GRAVITY);
        for (int i=0, i<graveSensor.size(); i++) {
            if ((gravSensors.get(i).getVendor().contains("Google Inc.")) &&
        (gravSensors.get(i).getVendor() ==3)) {
                // Ver.3의 중력 센서를 사용함
                mSensor = gravSensors.get(i)
                }
            }
        } else {
        //가속도 센서를 사용함
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            mSensor = mSensorManager.getDefaultSensor (Sensor.TYPE_ACCELEROMETER);
        } else {
            // 죄송합니다. 이 기기에는 가속도 센서가 없습니다.
        }
        }*/


