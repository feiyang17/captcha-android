package com.square;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int width = getWindowManager().getDefaultDisplay().getWidth();
		
		int height = getWindowManager().getDefaultDisplay().getHeight();
		
		System.out.println("width = " + width + "-----" + "height = " + height);
		
		Log.w("SplashActivity", "width = " + width + "-----" + "height = " + height);
		
		setContentView(R.layout.activity_splash);
		
		new Handler().postDelayed(new Runnable() {
			
			public void run() {
				Intent intent = new Intent(SplashActivity.this,MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}
		}, 2000);
	}
}
