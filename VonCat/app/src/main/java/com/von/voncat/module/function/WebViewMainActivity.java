package com.von.voncat.module.function;

import java.util.ArrayList;
import java.util.List;

import com.von.voncat.Constant;
import com.von.voncat.R;
import com.von.voncat.module.function.adapter.ListViewWebViewMainAdapter;
import com.von.voncat.module.function.model.ListViewWebViewMainModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class WebViewMainActivity extends Activity {
	private ListView listView_webview_main;
	private List<ListViewWebViewMainModel> list = new ArrayList<ListViewWebViewMainModel>();
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_web_view_main);
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
		listView_webview_main = (ListView) findViewById(R.id.listView_webview_main);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("WebView");
	}

	private void initData() {
		// TODO Auto-generated method stub
		list.clear();
		list.add(new ListViewWebViewMainModel("HOMEPAGE", WebViewBaseActivity.class, Constant.URL_HOMEPAGE, "", null));
		list.add(new ListViewWebViewMainModel("百度", WebViewBaseActivity.class, Constant.URL_BAIDU_SEARCH, "", null));
		list.add(new ListViewWebViewMainModel("AndroidDevTools", WebViewBaseActivity.class, Constant.URL_ANDROIDDEVTOOLS, "", null));
		listView_webview_main.setAdapter(new ListViewWebViewMainAdapter(this, list));
	}
}
