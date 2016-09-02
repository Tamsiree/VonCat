package com.von.voncat.module.ui.card.MultiCard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.von.voncat.R;

public class MultiCardActivity extends Activity  implements OnClickListener{
	private MultiCardMenu mc;
	String TAG = "MultiCardActivity";
	private LinearLayout ll_back;
	private TextView tv_title;
	private ScrollView ScrollView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_multi_card);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		initView();// 初始化控件 - FindViewById之类的操作
		initData();// 初始化控件的数据及监听事件
	}

	private void initData() {
		// TODO Auto-generated method stub
		
	}

	private void initView() {
		ScrollView1 = (ScrollView) findViewById(R.id.ScrollView1);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("UI 界面特效");
		mc = (MultiCardMenu) findViewById(R.id.multi_card_menu);
		
		for (int i = 0; i < 10; i++) {
			View v = LayoutInflater.from(this).inflate(R.layout.item_multicard, null);
			mc.addView(v);
		}
		
		
		LayoutParams lp = mc.getLayoutParams();
		
		WindowManager wm = this.getWindowManager();
		 
	    int width = wm.getDefaultDisplay().getWidth();
	    int height = wm.getDefaultDisplay().getHeight();
		
	    if(height > dip2px(this,200+50*mc.getChildCount())){
	    	lp.height = height - dip2px(this,70);
	    }else{
	    	lp.height = dip2px(this,200+50*mc.getChildCount());   
	    }
        mc.setLayoutParams(lp);
        ScrollView1.scrollTo(0, 0);
		mc.setOnDisplayOrHideListener(new MultiCardMenu.OnDisplayOrHideListener() {
			@Override
			public void onDisplay(int which) {
				Log.d(TAG, "onDisplay:" + which);
				ScrollView1.scrollTo(0, 0);
			}

			@Override
			public void onHide(int which) {
				Log.d(TAG, "onHide:" + which);
			}

			@Override
			public void onTouchCard(int which) {
				Log.d(TAG, "onTouchCard:" + which);
			}
		});
		CheckBox fade = (CheckBox) findViewById(R.id.fade);
		fade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mc.setFade(isChecked);
			}
		});
		CheckBox boundary = (CheckBox) findViewById(R.id.boundary);
		boundary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mc.setBoundary(isChecked);
			}
		});
		// int [] imgRes = {R.drawable.ent,R.drawable.qa};
		final int[] imgRes = { R.drawable.nuan1, R.drawable.nuan2,
				R.drawable.ic_launcher, R.drawable.qa, R.drawable.ent,
				R.drawable.nuan1, R.drawable.nuan2, R.drawable.ic_launcher,
				R.drawable.qa, R.drawable.ent, R.drawable.nuan1,
				R.drawable.nuan2, R.drawable.ic_launcher, R.drawable.qa,
				R.drawable.ent };
		final ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mViewPager.setAdapter(new PagerAdapter() {
			@Override
			public int getCount() {
				return imgRes.length;
			}

			@Override
			public boolean isViewFromObject(View view, Object object) {
				return view == object;
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				mViewPager.removeView((View) object);
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				ImageView imageView = new ImageView(MultiCardActivity.this);
				imageView.setImageResource(imgRes[position]);
				container.addView(imageView);
				return imageView;
			}
		});

		ListView listView = (ListView) findViewById(R.id.lv);
		listView.setAdapter(new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, data));

	}
	
	
	
	public static int dip2px(Context context, float dpValue) {  
		  final float scale = context.getResources().getDisplayMetrics().density;  
		  return (int) (dpValue * scale + 0.5f);  
		} 
	
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */ 
    public static int px2dip(Context context, float pxValue) { 
        final float scale = context.getResources().getDisplayMetrics().density; 
        return (int) (pxValue / scale + 0.5f); 
    }  

	String data[] = { "mother", "passion ", "smile 	", "love 		", "eternity 	",
			"fantastic ", "destiny ", "freedom ", "liberty 	", "tranquility ",
			"peace 	", "blossom ", "sunshine ", "sweetheart ", "gorgeous ",
			"cherish 	", "enthusiasm", "hope ", "grace ", "rainbow ", "blue 	",
			"sunflower ", "twinkle ", "serendipity", "bliss 		", "lullaby 		",
			"sophisticated 	", "renaissance 	", "cute 			", "cosy 			",
			"butterfly ", "galaxy ", "hilarious ", "moment", "extravaganza ",
			"aqua ", "sentiment ", "cosmopolitan ", "bubble ", "pumpkin",
			"banana", "lollipop ", "if 　", "bumblebee ", "giggle ", "paradox ",
			"peek-a-boo ", "umbrella ", "kangaroo ", "flabbergasted",
			"hippopotamus ", "gothic ", "coconut ", "smashing ", "whoops ",
			"tickle ", "loquacious ", "flip-flop ", "smithereens", "hi",
			"gazebo", "hiccup", "hodgepodge", "shipshape", "explosion",
			"fuselage", "zing", "gum", "hen-night " };

	public void hide(View view) {
		mc.hide(mc.getDisplayingCard());
	}

	@Override
	public void onBackPressed() {
		if (mc.isDisplaying()) {
			mc.hide(mc.getDisplayingCard());
		} else {
			super.onBackPressed();
		}
	}

	public void blue(View view) {
		Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
	}

	public void fail(View view) {
		Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
	}

	public void one(View view) {
		mc.show(0);
	}

	public void two(View view) {
		mc.show(1);
	}

	public void three(View view) {
		mc.show(2);
	}

	public void four(View view) {
		mc.show(3);
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
