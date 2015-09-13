package com.example.stitp;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 网络定位示例
 * */
public class sendActivity extends Activity implements AMapLocationListener {
	private LocationManagerProxy mLocationManagerProxy;
	private TextView time;
	private TextView location;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendlayout);
		init();
		initView();
	}

	private void init() {
		// TODO Auto-generated method stub
		// 初始化定位，只采用网络定位
		mLocationManagerProxy = LocationManagerProxy.getInstance(this);
		mLocationManagerProxy.setGpsEnable(false);
		// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
		// 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用removeUpdates()方法来取消定位请求
		// 在定位结束后，在合适的生命周期调用destroy()方法
		// 其中如果间隔时间为-1，则定位只定一次,
		// 在单次定位情况下，定位无论成功与否，都无需调用removeUpdates()方法移除请求，定位sdk内部会移除
		mLocationManagerProxy.requestLocationData(
				LocationProviderProxy.AMapNetwork, 60 * 1000, 15, this);
	}

	private void initView() {
		// TODO Auto-generated method stub
		ImageView img = (ImageView) findViewById(R.id.img);
		img.setImageBitmap(BitmapFactory.decodeFile(getIntent().getStringExtra(
				"imgDecodableString")));
		time = (TextView) findViewById(R.id.time);
		location = (TextView) findViewById(R.id.location);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(AMapLocation amapLocation) {
		// TODO Auto-generated method stub
		if (amapLocation != null
				&& amapLocation.getAMapException().getErrorCode() == 0) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(amapLocation.getTime());
			Toast.makeText(sendActivity.this,
					df.format(date) + amapLocation.getCity(),
					Toast.LENGTH_SHORT).show();
			time.setText(df.format(date));
			location.setText(amapLocation.getAddress());
		} else {
			Log.e("AmapErr", "Location ERR:"
					+ amapLocation.getAMapException().getErrorCode());
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// 移除定位请求
		mLocationManagerProxy.removeUpdates(this);
		// 销毁定位
		mLocationManagerProxy.destroy();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
