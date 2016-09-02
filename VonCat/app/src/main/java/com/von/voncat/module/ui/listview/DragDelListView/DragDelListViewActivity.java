package com.von.voncat.module.ui.listview.DragDelListView;

import java.util.List;

import com.von.voncat.R;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author https://github.com/younfor
 * 
 */
public class DragDelListViewActivity extends Activity implements View.OnClickListener{
	private List<ApplicationInfo> mAppList;
	private DragDelListView mListView;
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_drag_del_list_view);
		// 透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

		initView();//初始化控件 - FindViewById之类的操作
		initData();//初始化控件的数据及监听事件
	}

	private void initView() {
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("ListView特效");
	}

	private void initData() {
		mAppList = getPackageManager().getInstalledApplications(0);
		mListView = (DragDelListView) findViewById(R.id.listView);
		mListView.setAdapter(new DragDelListViewAdapter(this,mAppList));
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.ll_back:
				finish();
				break;
			default:
				break;
		}
	}
}
