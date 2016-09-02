package com.von.voncat.module.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.ui.card.MultiCard.MultiCardActivity;
import com.von.voncat.module.ui.SlidingDrawer.SlidingDrawerSingleActivity;
import com.von.voncat.module.ui.adapter.ListViewUIMainAdapter;
import com.von.voncat.module.ui.card.CardUIMainActivity;
import com.von.voncat.module.ui.dialog.DialogMainActivity;
import com.von.voncat.module.ui.listview.ListViewMainActivity;
import com.von.voncat.module.ui.model.ListViewUIMainModel;
import com.von.voncat.module.ui.progress.ProgressMainActivity;
import com.von.voncat.module.ui.viewgroup.VonViewGroupActivity;

public class UIMainActivity extends Activity implements OnClickListener{
	private ListView listView_UIMain;
	private List<ListViewUIMainModel> list = new ArrayList<ListViewUIMainModel>();
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_uimain);
		// 透明状态栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();//初始化控件 - FindViewById之类的操作
		initData();//初始化控件的数据及监听事件
	}

	private void initView() {
		listView_UIMain = (ListView) findViewById(R.id.listView_UIMain);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("UI 界面特效");
	}

	private void initData() {
		list.clear();
		list.add(new ListViewUIMainModel("Dialog Main", DialogMainActivity.class, "非常炫酷的dialog效果", R.drawable.icon_windom+""));
		list.add(new ListViewUIMainModel("CardView Main", CardUIMainActivity.class, "卡片视图", R.drawable.icon_cardview+""));
		list.add(new ListViewUIMainModel("SlidingDrawer Main", SlidingDrawerSingleActivity.class, "滑动式抽屉", null));
		list.add(new ListViewUIMainModel("Progress Main", ProgressMainActivity.class, "进度条视图", null));
		list.add(new ListViewUIMainModel("ListView", ListViewMainActivity.class, "ListView特效", null));
		list.add(new ListViewUIMainModel("ViewGroup", VonViewGroupActivity.class, "自定义的ViewGroup", null));
		listView_UIMain.setAdapter(new ListViewUIMainAdapter(this, list));
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
