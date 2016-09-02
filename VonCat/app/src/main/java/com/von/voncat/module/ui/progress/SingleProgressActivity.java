package com.von.voncat.module.ui.progress;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.utils.VonUtil;

public class SingleProgressActivity extends Activity implements OnClickListener{
	private int progress;
	private ProgressBar pb_line_of_credit;
	private int money;
	private LinearLayout ll_back;
	private TextView tv_title;
	private Button btn_diy_color;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_single_progress);
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
		/*GradientDrawable myGrad = (GradientDrawable) getResources()
				.getDrawable(R.drawable.shape_line_progress_white);
		myGrad.setColor(Color.CYAN);*/
		btn_diy_color = (Button) findViewById(R.id.btn_diy_color);
		btn_diy_color.setOnClickListener(this);
		pb_line_of_credit = (ProgressBar) findViewById(R.id.pb_line_of_credit);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("进度条视图");
	}
	
	private void initData() {
		// TODO Auto-generated method stub
		initLineProgress();
	}
	
	private void initLineProgress() {
		// TODO Auto-generated method stub
		//progress = 0;// 进度初始化
		
		money = 100001;
		if (money < 100 && money > 0) {
			pb_line_of_credit.setMax(100);
		} else if (money > 100 && money < 1000) {
			pb_line_of_credit.setMax(1000);
		} else if (money > 1000 && money < 5000) {
			pb_line_of_credit.setMax(5000);
		} else if (money > 5000 && money < 20000) {
			pb_line_of_credit.setMax(20000);
		} else if (money > 20000 && money < 100000) {
			pb_line_of_credit.setMax(100000);
		} else if (money > 100000) {
			pb_line_of_credit.setMax(VonUtil.StringToInt(money
					* 2 + ""));
		}
		/*int i =  (new Double(SysCtlUtil.StringToDouble(quota))).intValue();
		final int current = (new Double(SysCtlUtil.StringToDouble(quota_surplus))).intValue() ;
		pb_line_of_credit.setMax((i));*/
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					while (progress < pb_line_of_credit.getMax()) {
						progress += pb_line_of_credit.getMax() * 0.01;
						if(progress<pb_line_of_credit.getMax()){
							pb_line_of_credit.setProgress(progress);
							//tv_current.setText(progress+"");
						}
						Thread.sleep(8);
					}
					while (progress > 0) {
						progress -= pb_line_of_credit.getMax() * 0.01;
						if(progress>0){
							pb_line_of_credit.setProgress(progress);
							//tv_current.setText(progress+"");
						}
						Thread.sleep(8);
					}

					while (progress < money) {
						progress += money * 0.01;
						pb_line_of_credit.setProgress(progress);
						//tv_current.setText(progress+"");
						Thread.sleep(10);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ll_back:
			finish();
			break;
		case R.id.btn_diy_color:
			VonUtil.ShowToast(SingleProgressActivity.this, "更换颜色", false);
			GradientDrawable myGrad = (GradientDrawable) getResources()
			.getDrawable(R.drawable.shape_line_progress_white);
			Random random = new Random();
			myGrad.setColor(Color.parseColor("#"+Integer.toHexString(-(random.nextInt(16777216)+1))));
			recreate();
			break;
		default:
			break;
		}
	}
}
