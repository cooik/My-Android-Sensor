package com.example.accelerometerdemo;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
	private boolean color = false;
	private View view;
	private long lastUpdate;
	private int[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY,
			Color.GRAY, Color.GREEN, Color.LTGRAY, Color.WHITE, Color.YELLOW };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		view = findViewById(R.id.textview);
		view.setBackgroundColor(Color.GREEN);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		lastUpdate = System.currentTimeMillis();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sensorManager.unregisterListener(this);

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			getAccelerometer(event);
		}
	}

	private void getAccelerometer(SensorEvent event) {
		// TODO Auto-generated method stub
		float[] values = event.values;

		float x = values[0];
		float y = values[1];
		float z = values[2];

		float accelationSquareRoot = (x * x + y * y + z * z)
				/ (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
		long actualTiem = event.timestamp;

		if (accelationSquareRoot >= 2) {
			if (actualTiem - lastUpdate < 200) {
				return;
			}
			lastUpdate = actualTiem;
			Toast.makeText(this, "Device was shuffed", 3000).show();
			if (color) {
				view.setBackgroundColor(Color.GREEN);
			} else {
				Random random = new Random();
				view.setBackgroundColor(colors[Math.abs(random.nextInt()) % 9]);
			}
			color = !color;
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

}
