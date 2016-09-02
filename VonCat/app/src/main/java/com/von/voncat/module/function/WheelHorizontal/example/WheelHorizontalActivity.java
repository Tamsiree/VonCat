package com.von.voncat.module.function.WheelHorizontal.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.function.WheelHorizontal.AbstractWheel;
import com.von.voncat.module.function.WheelHorizontal.ArrayWheelAdapter;
import com.von.voncat.module.function.WheelHorizontal.OnWheelClickedListener;
import com.von.voncat.module.function.WheelHorizontal.OnWheelScrollListener;
import com.von.voncat.utils.VonUtil;

public class WheelHorizontalActivity extends Activity {
	private AbstractWheel wheelView_year_month;
	private List<String> listYearMonth = new ArrayList<String>();
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_wheel_horizontal);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();
		initData();
	}

	private void initView() {
		// TODO Auto-generated method stub
		wheelView_year_month = (AbstractWheel) findViewById(R.id.wheelView_year_month);
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
		tv_title.setText("功能效果");
	}

	private void initData() {
		// TODO Auto-generated method stub
		listYearMonth.clear();
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		for (int i = calendar.get(Calendar.YEAR)-3; i <= calendar.get(Calendar.YEAR)+2; i++) {
			for (int j = 1; j <= 12; j++) {
				listYearMonth.add(i+"年"+j+"月");
			}
		}
		String[] arr = (String[])listYearMonth.toArray(new String[listYearMonth.size()]);
		int CurrentIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH)+1)+"月")){
				CurrentIndex = i;
				break;
			}
		}
		
		ArrayWheelAdapter<String> ampmAdapter = new ArrayWheelAdapter<String>(
				this, arr);
		ampmAdapter.setItemResource(R.layout.item_wheel_year_month);
		ampmAdapter.setItemTextResource(R.id.tv_year);
		wheelView_year_month.setViewAdapter(ampmAdapter);
		// set current time
		wheelView_year_month.setCurrentItem(CurrentIndex);
		
		wheelView_year_month.addScrollingListener(new OnWheelScrollListener() {
			String before;
			String behind;

			@Override
			public void onScrollingStarted(AbstractWheel wheel) {
				before = listYearMonth.get(wheel.getCurrentItem());
			}

			@Override
			public void onScrollingFinished(AbstractWheel wheel) {
				behind = listYearMonth.get(wheel.getCurrentItem());
				Log.v("addScrollingListener","listYearMonth:" + listYearMonth.get(wheel.getCurrentItem()));
				if (!before.equals(behind)) {
					int year = VonUtil.StringToInt(listYearMonth.get(
							wheel.getCurrentItem()).substring(0, 4));
					int month = VonUtil.StringToInt(listYearMonth.get(
							wheel.getCurrentItem()).substring(5, 6));
					//initBarChart(VonUtil.getDaysByYearMonth(year, month));
				}
			}
		});
		wheelView_year_month.addClickingListener(new OnWheelClickedListener() {

			@Override
			public void onItemClicked(AbstractWheel wheel, int itemIndex) {
				Log.v("addScrollingListener","listYearMonth:" + listYearMonth.get(itemIndex));
				wheelView_year_month.setCurrentItem(itemIndex, true);
				/*
				 * int year =
				 * VonUtil.StringToInt(listYearMonth.get(itemIndex)
				 * .substring(0, 4)); int month =
				 * VonUtil.StringToInt(listYearMonth
				 * .get(itemIndex).substring(5, 6));
				 * initBarChart(VonUtil.getDaysByYearMonth(year, month));
				 */
			}
		});
	}
}
