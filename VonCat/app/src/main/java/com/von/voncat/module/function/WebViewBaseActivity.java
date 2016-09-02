package com.von.voncat.module.function;

import com.von.voncat.Constant;
import com.von.voncat.R;
import com.von.voncat.utils.VonUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class WebViewBaseActivity extends Activity {
	private WebView web_base;
	private ProgressBar pb_web_base;
	private String webPath;
	private LinearLayout ll_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_web_view_base);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();// 初始化控件 - FindViewById之类的操作
		initData();// 初始化控件的数据及监听事件
	}

	private void initView() {
		// TODO Auto-generated method stub
		web_base = (WebView) findViewById(R.id.web_base);
		pb_web_base = (ProgressBar) findViewById(R.id.pb_web_base);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 //预留下来的，交给webView自己判断  
                if (web_base.canGoBack()) {  
                	web_base.goBack();  
                } else {  
                   //如果没有可以back的url，则退出  
                	VonUtil.ShowToast(WebViewBaseActivity.this, "长按退出", false);
                }  
			}
		});
		ll_back.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				finish();
				return true;
			}
		});
	}

	private void initData() {
		pb_web_base.setMax(100);
		webPath = getIntent().getStringExtra("URL");
		if (VonUtil.isNullString(webPath)) {
			webPath = Constant.URL_BAIDU_SEARCH;
		}

		if (Build.VERSION.SDK_INT >= 19) {
			web_base.getSettings().setCacheMode(
					WebSettings.LOAD_CACHE_ELSE_NETWORK);
		}

		WebSettings webSettings = web_base.getSettings();
		webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
		webSettings.setSupportZoom(true);// 设置可以支持缩放
		webSettings.setBuiltInZoomControls(true);// 设置出现缩放工具
		webSettings.setDisplayZoomControls(false);//隐藏缩放工具
		webSettings.setUseWideViewPort(true);// 扩大比例的缩放
		// 自适应屏幕
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);

		web_base.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				pb_web_base.setProgress(newProgress);
				super.onProgressChanged(view, newProgress);
			}
		});
		web_base.setWebViewClient(new WebViewClient() {
			// 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				pb_web_base.setVisibility(View.VISIBLE);
				return true;
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO Auto-generated method stub
				pb_web_base.setVisibility(View.GONE);
				super.onPageFinished(view, url);
			}
		});
		web_base.loadUrl(webPath);
		Log.v("帮助类完整连接", webPath);

	}

}
