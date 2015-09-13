package com.example.stitp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected static final int RESULT_LOAD_IMG = 0;
	private Button enter;
	private OnClickListener clicklistener;
	private String imgDecodableString;
	private AlertDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initListener();
		initView();
	}

	private void initListener() {
		clicklistener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.enter:
					showdialog();
					break;
				case R.id.picture:
					Intent galleryIntent = new Intent(
							Intent.ACTION_PICK,
							android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
					startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
					dialog.dismiss();
					break;
				case R.id.sensor:
					dialog.dismiss();
					startActivity(new Intent(MainActivity.this,
							SensorActivity.class));
					break;
				}
			}
		};
	}

	protected void showdialog() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		LayoutInflater inflater = getLayoutInflater();
		View view = inflater.inflate(R.layout.dialog, null);
		builder.setView(view);
		Button take_picture = (Button) view.findViewById(R.id.picture);
		Button take_sensor = (Button) view.findViewById(R.id.sensor);
		take_picture.setOnClickListener(clicklistener);
		take_sensor.setOnClickListener(clicklistener);
		dialog = builder.create();
		dialog.show();
	}

	private void initView() {
		// TODO Auto-generated method stub
		enter = (Button) findViewById(R.id.enter);
		enter.setOnClickListener(clicklistener);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		try {
			if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
					&& null != data) {
				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				// Get the cursor
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				// Move to first row
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				imgDecodableString = cursor.getString(columnIndex);
				cursor.close();
				Intent intent2 = new Intent(MainActivity.this,
						sendActivity.class);
				intent2.putExtra("imgDecodableString", imgDecodableString);
				startActivity(intent2);
			} else {
				Toast.makeText(this, "You haven't picked Image",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
					.show();
		}

	}
}
