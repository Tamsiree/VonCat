package com.von.voncat.module.ui.dialog;

import java.util.ArrayList;
import java.util.List;

import com.von.voncat.R;
import com.von.voncat.R.layout;
import com.von.voncat.module.ui.adapter.ListViewDialogMainAdapter;
import com.von.voncat.module.ui.dialog.DialogLoadingProgressAcfunVideo.DialogLoadingProgressAcfunVideo;
import com.von.voncat.module.ui.dialog.DialogShapeLoadingView.ShapeLoadingDialog;
import com.von.voncat.module.ui.dialog.DialogWheel.WheelVertical.example.WheelYearMonthDayDialog;
import com.von.voncat.module.ui.model.ListViewDialogMainModel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DialogMainActivity extends Activity {

	private ListView listView_Dialog_Main;
	private List<ListViewDialogMainModel> list = new ArrayList<ListViewDialogMainModel>();
	private LinearLayout ll_back;
	private TextView tv_title;
	private TextView tv_date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(layout.activity_dialog_main);
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
		tv_date = (TextView) findViewById(R.id.tv_date);
		listView_Dialog_Main = (ListView) findViewById(R.id.listView_Dialog_Main);
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
		tv_title.setText("Dialog");
	}

	private void initData() {
		// TODO Auto-generated method stub
		initWheelYearMonthDayDialog();
		list.clear();
		list.add(new ListViewDialogMainModel("Acfun 视频加载 Dialog",new DialogLoadingProgressAcfunVideo(this), "一只可爱的A娘正在拼命的奔跑",null));
		list.add(new ListViewDialogMainModel("shapeLoadingViewDialog",
				new ShapeLoadingDialog(this).getDialog(), "跳跃效果的加载动画", null));
		list.add(new ListViewDialogMainModel("WheelYearMonthDayDialog",wheelYearMonthDayDialog, "可选择年月(日)的弹窗", null));
		listView_Dialog_Main.setAdapter(new ListViewDialogMainAdapter(this,list));
	}

	private WheelYearMonthDayDialog wheelYearMonthDayDialog;

	private void initWheelYearMonthDayDialog() {
		// ------------------------------------------------------------------选择日期开始
		wheelYearMonthDayDialog = new WheelYearMonthDayDialog(this);
		wheelYearMonthDayDialog.getTv_sure().setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if (wheelYearMonthDayDialog.getCheckBox_day().isChecked()) {
							tv_date.setText((wheelYearMonthDayDialog.getCurYear() - 5)+ wheelYearMonthDayDialog.getYear().getCurrentItem()+ "年"+ wheelYearMonthDayDialog.getMonths()[wheelYearMonthDayDialog.getMonth().getCurrentItem()] + "月" + (wheelYearMonthDayDialog.getDay().getCurrentItem() + 1) + "日");
						} else {
							tv_date.setText((wheelYearMonthDayDialog
									.getCurYear() - 5)
									+ wheelYearMonthDayDialog.getYear()
											.getCurrentItem()
									+ "年"
									+ wheelYearMonthDayDialog.getMonths()[wheelYearMonthDayDialog
											.getMonth().getCurrentItem()] + "月");
						}
						wheelYearMonthDayDialog.cancel();
					}
				});
		wheelYearMonthDayDialog.getTv_cancle().setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						wheelYearMonthDayDialog.cancel();
					}
				});
		// ------------------------------------------------------------------选择日期结束
	}
}
