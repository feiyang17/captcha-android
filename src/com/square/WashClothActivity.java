package com.square;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class WashClothActivity extends Activity {

	private WebView webView;

	private Button button1, button2;

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_washcloth);
		((TextView)findViewById(R.id.title)).setText("蘑菇街");
        ((TextView)findViewById(R.id.title)).setTextColor(Color.parseColor("#FF3366"));

		button1 = (Button) findViewById(R.id.btn_login_cloth_grey);
		button2 = (Button) findViewById(R.id.btn_back);
		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(WashClothActivity.this,
						MainActivity.class);
				startActivity(intent);
				WashClothActivity.this.finish();
			}
		});

		webView = (WebView) findViewById(R.id.cloth_webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		// webView.setInitialScale(0);
		webView.addJavascriptInterface(new JSInterface(), "control");
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		// webView.setWebChromeClient(new WebChromeClient(){});
		webView.loadUrl(String.format("%swasher.html", DataCenter.URL));
		//webView.loadUrl("http://10.18.230.42:8888/github.repo/captcha/washer.html");
		
		
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			int arg1 = msg.arg1;
			switch (arg1) {
			case 2:
				button1.setBackgroundResource(R.drawable.login);
				button1.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						Uri uri = Uri.parse("http://www.mogujie.com/");
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
					}
				});
				break;
//			case 3:
//				webView.reload();
//				break;
			default:
				break;
			}
		}
	};

	class JSInterface {
		@JavascriptInterface
		public void toastMessage(String messages) {
			int msgs = Integer.valueOf(messages);
			Message msg = Message.obtain();
			switch (msgs) {
			case 1:
				msg.arg1 = 2;
				handler.sendMessage(msg);
				break;
			case 0:
//				msg.arg1 = 3;
//				handler.sendMessage(msg);
				break;
			default:
				break;
			}
		}
	}
}
