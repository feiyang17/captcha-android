package com.square;

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

public class PianoActivity extends Activity {

	private Button button1, button2;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_piano);
		((TextView)findViewById(R.id.title)).setText("天天刮奖");
		((TextView)findViewById(R.id.title)).setTextColor(Color.parseColor("#FF3333"));

		button1 = (Button) findViewById(R.id.btn_piano);
		button2 = (Button) findViewById(R.id.btn_back);

		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(PianoActivity.this,
						MainActivity.class);
				startActivity(intent);
				PianoActivity.this.finish();
			}
		});

		webView = (WebView) findViewById(R.id.cloth_webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		// webView.setInitialScale(0);
		webView.addJavascriptInterface(new JSInterface(), "control");
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webView.loadUrl(String.format("%spiano.html", DataCenter.URL));
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
				button1.setBackgroundResource(R.drawable.pianobtn);
				button1.setOnClickListener(new OnClickListener() {

					public void onClick(View arg0) {
						Uri uri = Uri.parse("http://www.pearlriverpiano.com/");
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
					}
				});
				break;
			case 3:
				//webView.reload();
				break;
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
				msg.arg1 = 3;
				handler.sendMessage(msg);
				break;
			default:
				break;
			}
		}
	}
}
