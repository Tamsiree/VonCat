package com.von.voncat.module.ui.progress;

import java.util.ArrayList;
import java.util.List;

import com.von.voncat.R;
import com.von.voncat.R.layout;
import com.von.voncat.module.ui.adapter.ListViewUIMainAdapter;
import com.von.voncat.module.ui.model.ListViewUIMainModel;
import com.von.voncat.module.ui.progress.RoundProgressBar.example.RoundProgressBarActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProgressMainActivity extends Activity implements OnClickListener{
	private ListView listView_progress_main;
	private List<ListViewUIMainModel> list = new ArrayList<ListViewUIMainModel>();
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(layout.activity_progress_main);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();//初始化控件 - FindViewById之类的操作
		initData();//初始化控件的数据及监听事件
	}
	private void initView() {
		// TODO Auto-generated method stub
		listView_progress_main = (ListView) findViewById(R.id.listView_progress_main);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("进度条视图");
	}

	private void initData() {
		// TODO Auto-generated method stub
		list.clear();
		list.add(new ListViewUIMainModel("SingleProgressBar", SingleProgressActivity.class, "自定义可换色进度条效果", null));
		list.add(new ListViewUIMainModel("RoundProgressBar", RoundProgressBarActivity.class, "非常炫酷的扇形进度条效果", null));
		listView_progress_main.setAdapter(new ListViewUIMainAdapter(this, list));
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
