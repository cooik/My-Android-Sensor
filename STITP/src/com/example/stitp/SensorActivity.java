package com.example.stitp;

import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SensorActivity extends Activity {
	ListView sensors;
	SensorManager mSensorManager;
	List<Sensor> allSensor = new ArrayList<Sensor>();
	List<String> SensorName = new ArrayList<String>();
	SimpleAdapter adapter;
	// SensorEventListener selforaccelerometer;
	// SensorEventListener selformagnetometer;
	// SensorEventListener selforgyroscope;
	// SensorEventListener selfororientation;
	// SensorEventListener selforgravity;
	// SensorEventListener selforlinear_acceleration;
	// SensorEventListener selforrotation_vector;
	// SensorEventListener selforproximity;
	// SensorEventListener selforlight;
	// SensorEventListener selforstepcounter;
	List<SensorEventListener> allsensoreventlis = new ArrayList<SensorEventListener>();
	Button btnforaccelerometer;
	Button btnformagnetometer;
	Button btnforgyroscope;
	Button btnfororientation;
	Button btnforgravity;
	Button btnforlinear_acceleration;
	Button btnforrotation_vector;
	Button btnforproximity;
	Button btnforlight;
	Button btnforstepcounter;
	Button btnforpressure;
	Button btnfortemperature;
	OnClickListener btnListener;
	TextView info;
	TextView title;
	StringBuilder infostr;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sensoractivity);
		initSensor();
		initListener();
		initView();
	}

	private void initListener() {
		// TODO Auto-generated method stub
		btnListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.accelerometer:
					title.setText("加速度传感器");
					info.setText("传感器失效");
					Sensor sensora = mSensorManager
							.getDefaultSensor(SensorManager.SENSOR_ACCELEROMETER);
					SensorEventListener selforaccelerometer = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("Accel X:" + event.values[0] + "\n"
									+ "Accel Y:" + event.values[1] + "\n"
									+ "Accel Z:" + event.values[2] + "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};

					unregiesterall();
					mSensorManager.registerListener(selforaccelerometer,
							sensora, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforaccelerometer);
					break;
				case R.id.magnetometer:
					title.setText("地磁传感器");
					info.setText("传感器失效");
					Sensor sensorm = mSensorManager
							.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
					SensorEventListener selformagnetometer = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("M-sensor X:" + event.values[0] + "\n"
									+ "M-sensor Y:" + event.values[1] + "\n"
									+ "M-sensor Z:" + event.values[2] + "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selformagnetometer,
							sensorm, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selformagnetometer);
					break;
				case R.id.orientation:
					title.setText("方向传感器");
					info.setText("传感器失效");
					Sensor sensoro = mSensorManager
							.getDefaultSensor(SensorManager.SENSOR_ORIENTATION);
					SensorEventListener selfororientation = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("Orientation X:" + event.values[0]
									+ "\n" + "Orientation Y:" + event.values[1]
									+ "\n" + "Orientation Z:" + event.values[2]
									+ "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selfororientation, sensoro,
							SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selfororientation);
					break;
				case R.id.gravity:
					title.setText("重力传感器");
					info.setText("传感器失效");
					Sensor sensorg = mSensorManager
							.getDefaultSensor((int) Sensor.TYPE_GRAVITY);
					SensorEventListener selforgravity = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("gravity X:" + event.values[0] + "\n"
									+ "gravity Y:" + event.values[1] + "\n"
									+ "gravity Z:" + event.values[2] + "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforgravity, sensorg,
							SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforgravity);
					break;

				case R.id.linear_acceleration:
					title.setText("线性加速度");
					info.setText("传感器失效");
					Sensor sensorl = mSensorManager
							.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
					SensorEventListener selforlinear_acceleration = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("linear_acceleration X:"
									+ event.values[0] + "\n"
									+ "linear_acceleration Y:"
									+ event.values[1] + "\n"
									+ "linear_acceleration Z:"
									+ event.values[2] + "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforlinear_acceleration,
							sensorl, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforlinear_acceleration);
					break;
				case R.id.rotation_vector:
					title.setText("旋转矢量");
					info.setText("传感器失效");
					Sensor sensorr = mSensorManager
							.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
					SensorEventListener selforrotation_vector = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("rotation_vector X:" + event.values[0]
									+ "\n" + "rotation_vector Y:"
									+ event.values[1] + "\n"
									+ "rotation_vector Z:" + event.values[2]
									+ "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforrotation_vector,
							sensorr, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforrotation_vector);
					break;
				case R.id.proximity:
					title.setText("近距离感应");
					info.setText("传感器失效");
					Sensor sensorp = mSensorManager
							.getDefaultSensor(Sensor.TYPE_PROXIMITY);
					SensorEventListener selforproximity = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("proximity :" + event.values[0] + "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforproximity, sensorp,
							SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforproximity);
					break;
				case R.id.light:
					title.setText("光传感器");
					info.setText("传感器失效");
					Sensor sensorli = mSensorManager
							.getDefaultSensor(Sensor.TYPE_LIGHT);
					SensorEventListener selforlight = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("light :" + event.values[0] + "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforlight, sensorli,
							SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforlight);
					break;
				case R.id.stepcounter:
					title.setText("计步器");
					info.setText("传感器失效");
					Sensor sensorstep = mSensorManager
							.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
					SensorEventListener selforstepcounter = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("step counter :" + event.values[0]
									+ "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforstepcounter,
							sensorstep, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforstepcounter);
					break;
				case R.id.pressure:
					title.setText("压力传感器");
					info.setText("传感器失效");
					Sensor sensorpressure = mSensorManager
							.getDefaultSensor(Sensor.TYPE_PRESSURE);
					SensorEventListener selforpressure = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("pressure :" + event.values[0]
									+ " hPa\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforpressure,
							sensorpressure, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforpressure);
					break;
				case R.id.gyroscope:
					title.setText("陀螺仪传感器");
					info.setText("传感器失效");
					Sensor gyroscope = mSensorManager
							.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
					SensorEventListener selforgyroscope = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("gyroscope X:" + event.values[0]
									+ "\n" + "gyroscope Y:" + event.values[1]
									+ "\n" + "gyroscope Z:" + event.values[2]
									+ "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selforgyroscope, gyroscope,
							SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selforgyroscope);
					break;
				case R.id.temperature:
					title.setText("温度传感器");
					info.setText("传感器失效");
					Sensor temperature = mSensorManager
							.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
					SensorEventListener selfortemperature = new SensorEventListener() {

						@Override
						public void onSensorChanged(SensorEvent event) {
							// TODO Auto-generated method stub
							info.setText("temperature :" + event.values[0]
									+ "\n");
						}

						@Override
						public void onAccuracyChanged(Sensor sensor,
								int accuracy) {
							// TODO Auto-generated method stub

						}
					};
					unregiesterall();
					mSensorManager.registerListener(selfortemperature,
							temperature, SensorManager.SENSOR_DELAY_NORMAL);
					allsensoreventlis.add(selfortemperature);
					break;
				default:
					break;
				}
			}
		};
	}

	protected void unregiesterall() {
		// TODO Auto-generated method stub
		for (SensorEventListener listener : allsensoreventlis) {
			mSensorManager.unregisterListener(listener);
		}
	}

	private void initSensor() {
		// TODO Auto-generated method stub
		mSensorManager = (android.hardware.SensorManager) getSystemService(SENSOR_SERVICE);
		// allSensor = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		// for (Sensor sensor : allSensor) {
		// SensorName.add(sensor.getName());
		// }

	}

	private void initView() {
		// TODO Auto-generated method stub
		// sensors = (ListView) findViewById(R.id.sensors);
		// sensors.setAdapter(new ArrayAdapter<String>(this,
		// android.R.layout.simple_expandable_list_item_1, SensorName));
		btnforaccelerometer = (Button) findViewById(R.id.accelerometer);
		btnformagnetometer = (Button) findViewById(R.id.magnetometer);
		btnforpressure = (Button) findViewById(R.id.pressure);
		btnforgyroscope = (Button) findViewById(R.id.gyroscope);
		btnfororientation = (Button) findViewById(R.id.orientation);
		btnforgravity = (Button) findViewById(R.id.gravity);
		btnforlinear_acceleration = (Button) findViewById(R.id.linear_acceleration);
		btnforrotation_vector = (Button) findViewById(R.id.rotation_vector);
		btnforproximity = (Button) findViewById(R.id.proximity);
		btnforlight = (Button) findViewById(R.id.light);
		btnfortemperature = (Button) findViewById(R.id.temperature);
		btnforstepcounter = (Button) findViewById(R.id.stepcounter);
		btnforaccelerometer.setOnClickListener(btnListener);
		btnformagnetometer.setOnClickListener(btnListener);
		btnforgyroscope.setOnClickListener(btnListener);
		btnfororientation.setOnClickListener(btnListener);
		btnforgravity.setOnClickListener(btnListener);
		btnforlinear_acceleration.setOnClickListener(btnListener);
		btnforrotation_vector.setOnClickListener(btnListener);
		btnforproximity.setOnClickListener(btnListener);
		btnforlight.setOnClickListener(btnListener);
		btnforstepcounter.setOnClickListener(btnListener);
		btnforpressure.setOnClickListener(btnListener);
		btnfortemperature.setOnClickListener(btnListener);
		info = (TextView) findViewById(R.id.sensor_info);
		title = (TextView) findViewById(R.id.title);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
}
