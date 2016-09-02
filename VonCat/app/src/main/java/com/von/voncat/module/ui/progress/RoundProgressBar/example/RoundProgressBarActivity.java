package com.von.voncat.module.ui.progress.RoundProgressBar.example;


import com.von.voncat.R.id;
import com.von.voncat.R.layout;
import com.von.voncat.module.ui.progress.RoundProgressBar.RoundProgressBar;
import com.von.voncat.utils.VonUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RoundProgressBarActivity extends Activity implements OnClickListener{
	private RoundProgressBar roundProgressBar1;
	private double progress;
	private double max_money = 0;
	private LinearLayout ll_back;
	private TextView tv_title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(layout.activity_round_progress_bar);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();
		initRoundProgress();
	}
	private void initView() {
		// TODO Auto-generated method stub
		roundProgressBar1 = (RoundProgressBar) findViewById(id.roundProgressBar1);
		ll_back = (LinearLayout) findViewById(id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(id.tv_title);
		tv_title.setText("进度条视图");
	}
	
	double money = 1000;

	private void initRoundProgress() {
		// TODO Auto-generated method stub
		progress = 0;// 进度初始化
		
		if(max_money<=0){
			if (money < 100 && money > 0) {
				roundProgressBar1.setMax(100);
			} else if (money >= 100 && money < 1000) {
				roundProgressBar1.setMax(1000);
			} else if (money >= 1000 && money < 5000) {
				roundProgressBar1.setMax(5000);
			} else if (money >= 5000 && money < 20000) {
				roundProgressBar1.setMax(20000);
			} else if (money >= 20000 && money < 100000) {
				roundProgressBar1.setMax(100000);
			} else if (money >= 100000) {
				roundProgressBar1.setMax(VonUtil.StringToInt(money * 1.1 + ""));
			}
		}else{
			roundProgressBar1.setMax(max_money);
		}
		/**/
		/*
		 * int i = (new Double(max_money)).intValue();
		 * roundProgressBar1.setMax((i));
		 */

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					while (progress < roundProgressBar1.getMax()) {
						progress += roundProgressBar1.getMax() * 0.01;
						if (progress < roundProgressBar1.getMax()) {
							roundProgressBar1.setProgress(progress);
						}
						Thread.sleep(8);
					}
					while (progress > 0) {
						progress -= roundProgressBar1.getMax() * 0.01;
						if (progress > 0) {
							roundProgressBar1.setProgress(progress);
						}
						Thread.sleep(8);
					}

					if(money!=0){
						while (progress < money) {
							progress += money * 0.01;
							roundProgressBar1.setProgress(progress);
							Thread.sleep(10);
						}
					}

					roundProgressBar1.setProgress(money);
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
		case id.ll_back:
			finish();
			break;
		default:
			break;
		}
	}
}
