package com.von.voncat.module.function;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.utils.VonUtil;

public class FileToBitmapActivity extends Activity implements OnClickListener{
	private LinearLayout ll_bg;
	private ImageView iv_img,iv_img_half_up,iv_img_half_center,iv_img_half_down;
	private Bitmap bitmap;
	// 获取原图片的宽和高
	int picWidth;
	int picHeight;
	private LinearLayout ll_back;
	private TextView tv_title;


	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_file_to_bitmap);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();//初始化控件 - FindViewById之类的操作
		new Thread(new Runnable() {
			@Override
			public void run() {
				bitmap = VonUtil
						.GetLocalOrNetBitmap("http://pic.baike.soso.com/p/20130508/20130508223624-128859399.jpg");

				mHandler.post(runnableUI);
			}
		}).start();
		initData();
	}

	private void initView() {
		iv_img = (ImageView) findViewById(R.id.iv_img);
		iv_img_half_up = (ImageView) findViewById(R.id.iv_img_half_up);
		iv_img_half_center = (ImageView) findViewById(R.id.iv_img_half_center);
		iv_img_half_down = (ImageView) findViewById(R.id.iv_img_half_down);
		ll_bg = (LinearLayout) findViewById(R.id.ll_bg);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("获取图片并截取");
	}

	private void initData() {
		/*
		 *     DisplayMetrics dm = new DisplayMetrics(); 
        this.getWindowManager().getDefaultDisplay().getMetrics(dm); 
         
        // 得到屏幕的长和宽  
        int screenWidth = dm.widthPixels;                //水平分辨率  
        int screenHeight = dm.heightPixels;              //垂直分辨率  
		 */
	}

	Handler mHandler = new Handler();

	Runnable runnableUI = new Runnable() {
		public void run() {
			// 得到图片的长和宽
			picWidth = bitmap.getWidth();
			picHeight = bitmap.getHeight();
			
			Bitmap bit_up = Bitmap.createBitmap(bitmap, 0, 0, picWidth,
					picHeight / 2);
			
			Bitmap bit_center = Bitmap.createBitmap(bitmap, 0, picHeight/4, picWidth,
					picHeight / 2);
			Bitmap bit_down = Bitmap.createBitmap(bitmap, 0, picHeight / 2, picWidth,
					picHeight / 2);
			
			iv_img.setImageBitmap(bitmap);
			iv_img_half_up.setImageBitmap(bit_up);
			iv_img_half_center.setImageBitmap(bit_center);
			iv_img_half_down.setImageBitmap(bit_down);
//			 Drawable drawable = VonUtil.bitmap2Drawable(picNewRes);  
//			ll_bg.setBackground(drawable);
		}
	};
	
	
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
