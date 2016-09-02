package com.von.voncat.module.ui.SlidingDrawer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.von.voncat.R;

public class SlidingDrawerSingleActivity extends Activity implements
		OnClickListener {
	@SuppressWarnings("deprecation")
	private SlidingDrawer mDrawer;
	private ImageView iv_slide;
	private Boolean flag = false;
	private LinearLayout ll_back;
	private TextView tv_title;
	private WebView web_base;
	private ProgressBar pb_web_base;
	private String webPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sliding_drawer_single);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();
		initData();
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		pb_web_base = (ProgressBar) findViewById(R.id.pb_web_base);
		web_base = (WebView) findViewById(R.id.web_base);
		iv_slide = (ImageView) findViewById(R.id.iv_slide);
		mDrawer = (SlidingDrawer) findViewById(R.id.slidingdrawer);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("滑动式抽屉");
	}

	@SuppressWarnings("deprecation")
	private void initData() {
		mDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
			@Override
			public void onDrawerOpened() {
				flag = true;
				iv_slide.setImageResource(R.drawable.slibe_down);
			}
		});
		mDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
			@Override
			public void onDrawerClosed() {
				flag = false;
				iv_slide.setImageResource(R.drawable.slibe_up);
			}
		});
		mDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
			@Override
			public void onScrollEnded() {
			}

			@Override
			public void onScrollStarted() {
			}
		});
		
		pb_web_base.setMax(100);
			webPath = "http://www.cnblogs.com/bluestorm/p/3716540.html";

		if (Build.VERSION.SDK_INT >= 19) {
			web_base.getSettings().setCacheMode(
					WebSettings.LOAD_CACHE_ELSE_NETWORK);
		}

		WebSettings webSettings = web_base.getSettings();
		webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
		// 设置可以支持缩放 
		webSettings.setSupportZoom(true); 
		// 设置出现缩放工具 
		webSettings.setBuiltInZoomControls(true);
		webSettings.setDisplayZoomControls(false);//隐藏缩放工具
		//扩大比例的缩放
		webSettings.setUseWideViewPort(true);
		//自适应屏幕
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);

		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ll_back:
			finish();
			break;
		default:
			break;
		}
	}
}
