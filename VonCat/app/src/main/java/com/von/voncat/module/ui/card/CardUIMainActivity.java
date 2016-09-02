package com.von.voncat.module.ui.card;

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
import com.von.voncat.module.ui.adapter.ListViewUIMainAdapter;
import com.von.voncat.module.ui.card.MultiCard.MultiCardActivity;
import com.von.voncat.module.ui.card.cardui.example.CardUIActivity;
import com.von.voncat.module.ui.model.ListViewUIMainModel;

public class CardUIMainActivity extends Activity implements OnClickListener{
	private ListView listView_card_UIMain;
	private List<ListViewUIMainModel> list = new ArrayList<ListViewUIMainModel>();
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_card_uimain);
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
		listView_card_UIMain = (ListView) findViewById(R.id.listView_card_UIMain);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("CardView View");
	}

	private void initData() {
		// TODO Auto-generated method stub
		list.clear();
		list.add(new ListViewUIMainModel("卡片式视图 1", CardUIActivity.class, "多张卡片叠加效果1", R.drawable.icon_cardview+""));
		list.add(new ListViewUIMainModel("卡片式视图 2", MultiCardActivity.class, "多张卡片叠加效果2", R.drawable.icon_cardview+""));
		listView_card_UIMain.setAdapter(new ListViewUIMainAdapter(this, list));
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
