package com.square;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView imageView1, imageView2, imageView3, imageView4,
			imageView5, imageView6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		imageView4 = (ImageView) findViewById(R.id.imageView4);
		imageView5 = (ImageView) findViewById(R.id.imageView5);
		imageView6 = (ImageView) findViewById(R.id.imageView6);

		imageView1.setOnClickListener(this);
		imageView2.setOnClickListener(this);
		imageView3.setOnClickListener(this);
		imageView4.setOnClickListener(this);
		imageView5.setOnClickListener(this);
		imageView6.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView1:
			Intent intent1 = new Intent(MainActivity.this,
					WashClothActivity.class);
			startActivity(intent1);
			break;
		case R.id.imageView2:
			Intent intent2 = new Intent(MainActivity.this,
					GravityActivity.class);
			startActivity(intent2);
			break;
		case R.id.imageView3:
			Toast.makeText(MainActivity.this, "去游泳", Toast.LENGTH_LONG).show();
//			Intent intent3 = new Intent(MainActivity.this,
//					PianoActivity.class);
//			startActivity(intent3);
			break;
		case R.id.imageView4:
			Intent intent4 = new Intent(MainActivity.this, EggActivity.class);
			startActivity(intent4);
			break;
		case R.id.imageView5:
			Intent intent5 = new Intent(MainActivity.this, PianoActivity.class);
			startActivity(intent5);
			break;
		case R.id.imageView6:
			Toast.makeText(MainActivity.this, "插插座", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
}
