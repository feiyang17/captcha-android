package com.square;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Toast;

public class GravityActivity extends Activity {

	private TextView textView;
	private Button button1,button2;
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gravity);
		((TextView)findViewById(R.id.title)).setText("投票");
		((TextView)findViewById(R.id.title)).setTextColor(Color.parseColor("#996666"));
		button1 = (Button)findViewById(R.id.btn_login_cloth_grey);
		button2 = (Button)findViewById(R.id.btn_back);
		textView = (TextView) findViewById(R.id.count);
		
		button2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(GravityActivity.this, MainActivity.class);
				startActivity(intent);
				GravityActivity.this.finish();
			}
		});
		
		webView = (WebView)findViewById(R.id.cloth_webview);
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		//webView.setInitialScale(0);
		webView.addJavascriptInterface(new JSInterface(), "control");
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		//webView.setWebChromeClient(new WebChromeClient(){});
		webView.loadUrl(String.format("%sshake.html", DataCenter.URL));
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
	}
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			int arg1 =msg.arg1;
			switch (arg1) {
			case 1:
				button1.setBackgroundResource(R.drawable.catbtn);
				button1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View arg0) {
						Toast.makeText(getApplicationContext(),  "ͶƱ�ɹ�", Toast.LENGTH_LONG)
						.show();
						textView.setText(String.valueOf(100));
					}
				});
				break;
				
			default:
				break;
			}
		}
	};
	
	class JSInterface{
		@JavascriptInterface
		public void toastMessage(String messages) {
			int msgs = Integer.valueOf(messages);
			switch (msgs) {
			case 1:
				Message msg = Message.obtain();
				msg.arg1 = 1;
				handler.sendMessage(msg);
				break;
			case 0:
//				Toast.makeText(getApplicationContext(),  "��֤ʧ�ܣ�������...", Toast.LENGTH_LONG)
//				.show();
				//webView.reload();
				break;
			default:
				break;
			}
		}
	}
}
