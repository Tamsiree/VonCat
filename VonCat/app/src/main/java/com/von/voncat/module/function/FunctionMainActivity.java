package com.von.voncat.module.function;

import java.util.ArrayList;
import java.util.List;
import com.von.voncat.R;
import com.von.voncat.module.function.CircleHead.CircleHeadActivity;
import com.von.voncat.module.function.CreateQRCode.CreateQRCodeActivity;
import com.von.voncat.module.function.ScannerCode.ScanerCodeActivity;
import com.von.voncat.module.function.WheelHorizontal.example.WheelHorizontalActivity;
import com.von.voncat.module.function.speech.SpeechActivity;
import com.von.voncat.module.ui.adapter.ListViewUIMainAdapter;
import com.von.voncat.module.ui.model.ListViewUIMainModel;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class FunctionMainActivity extends Activity implements OnClickListener{
	private ListView listView_Function_Main;
	private List<ListViewUIMainModel> list = new ArrayList<ListViewUIMainModel>();
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_function_main);
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
		listView_Function_Main = (ListView) findViewById(R.id.listView_Function_Main);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("功能效果");
	}

	private void initData() {
		list.clear();
		list.add(new ListViewUIMainModel("WebView", WebViewMainActivity.class, "WebView界面", R.drawable.icon_function+""));
		list.add(new ListViewUIMainModel("WheelHorizontalView", WheelHorizontalActivity.class, "横向滑动选择日期", R.drawable.icon_function+""));
		list.add(new ListViewUIMainModel("FileToBitmap", FileToBitmapActivity.class, "本地/网络图片文件转bitmap 并只显示一半", R.drawable.icon_function+""));
		list.add(new ListViewUIMainModel("Scanner QR Code / QR Code", ScanerCodeActivity.class, "扫描二维码，条形码", R.drawable.icon_function+""));
		list.add(new ListViewUIMainModel("CreateQRCode", CreateQRCodeActivity.class, "生成二维码和条形码", R.drawable.icon_function+""));
		list.add(new ListViewUIMainModel("CircleHead", CircleHeadActivity.class, "从相机/相册 获取图片 并展出为圆形头像", R.drawable.icon_function+""));
		list.add(new ListViewUIMainModel("Speech", SpeechActivity.class, "语音识别并进行百度搜索", R.drawable.icon_function+""));
		listView_Function_Main.setAdapter(new ListViewUIMainAdapter(this, list));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_back:
			finish();
			break;
		default:
			break;
		}
	}
}
