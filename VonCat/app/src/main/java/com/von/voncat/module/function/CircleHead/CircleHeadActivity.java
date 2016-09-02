package com.von.voncat.module.function.CircleHead;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.von.voncat.R;
import com.von.voncat.module.ui.dialog.TransparentDialog;

public class CircleHeadActivity extends Activity implements OnClickListener {
	private CircleImageView civ_head;
	private LinearLayout ll_back;
	private TextView tv_title;
	private LinearLayout ll_bg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_circle_head);
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
		civ_head = (CircleImageView) findViewById(R.id.civ_head);
		civ_head.setOnClickListener(this);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("获取相机或相册图片成圆形");
		ll_bg = (LinearLayout) findViewById(R.id.ll_bg);
		ll_bg.setOnLongClickListener(new OnLongClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				
				if(bitmap!= null){
				 Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
					    @Override  
					    public void onGenerated(Palette palette) {  
					         Palette.Swatch vibrant =  palette.getVibrantSwatch();  
					          if (vibrant != null) {  
					        	  /*
					        	   * 
									    Vibrant(充满活力的)
									    Vibrant dark(充满活力的黑)
									    Vibrant light(充满活力的亮)
									    Muted(柔和的)
									    Muted dark(柔和的黑)
									    Muted lighr(柔和的亮)
					        	   */
					              // If we have a vibrant color  
					              // update the title TextView  
					        	/*  ll_bg.setBackgroundColor(vibrant.getRgb());  */
					        	  if (isMark) {
					        		  isMark = false;
					        		  ll_bg.setBackgroundColor(vibrant.getRgb()); 
					        	  }else{
					        		  isMark = true;
					        		  ll_bg.setBackgroundColor(vibrant.getTitleTextColor());  
					        	  }
					          }  
					    }  
					});
				 
				}
				return false;
			}
				
		});
	}
	
	private void initData() {
		// TODO Auto-generated method stub
	}
	private boolean isMark = false;
	private Bitmap bitmap;
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (arg0.getId()) {
		case R.id.ll_back:
			finish();
			break;
		case R.id.civ_head:
			final TransparentDialog dialog1 = new TransparentDialog(
					CircleHeadActivity.this);
			View dialogView1 = LayoutInflater.from(CircleHeadActivity.this)
					.inflate(R.layout.dialog_upload_headicon, null);
			TextView tv_camera = (TextView) dialogView1
					.findViewById(R.id.tv_camera);
			TextView tv_file = (TextView) dialogView1
					.findViewById(R.id.tv_file);
			TextView tv_cancelid = (TextView) dialogView1
					.findViewById(R.id.tv_cancelid);
			tv_cancelid.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					dialog1.cancel();
				}
			});
			tv_camera.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method
					// stub
					getImageFromCamera();
					dialog1.cancel();
				}
			});
			tv_file.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method
					// stub
					getImageFromAlbum();
					dialog1.cancel();
				}
			});
			dialog1.setContentView(dialogView1);
			dialog1.show();
			break;
		}
	}

	private int REQUEST_CODE_PICK_IMAGE = 10;
	private int REQUEST_CODE_CAPTURE_CAMEIA = 11;

	// private String capturePath;

	protected void getImageFromCamera() {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			Intent getImageByCamera = new Intent(
					"android.media.action.IMAGE_CAPTURE");
			startActivityForResult(getImageByCamera,
					REQUEST_CODE_CAPTURE_CAMEIA);
		} else {
			Toast.makeText(getApplicationContext(), "请确认已经插入SD卡",
					Toast.LENGTH_LONG).show();
		}
	}

	protected void getImageFromAlbum() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("image/*");// 相片类型
		startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == 0) {
			return;
		}

		if (requestCode == REQUEST_CODE_PICK_IMAGE) {
			Uri uri = data.getData();
			if (uri == null) {
				// use bundle to get data
				Bundle bundle = data.getExtras();
				if (bundle != null) {
					Bitmap photo = (Bitmap) bundle.get("data"); // get
																// bitmap
					// spath :生成图片取个名字和路径包含类型
					civ_head.setImageBitmap(photo);
					// saveImage(photo,capturePath);
				} else {
					Toast.makeText(getApplicationContext(), "err****",
							Toast.LENGTH_LONG).show();
					return;
				}
			} else {
					//Bitmap bitmap=BitmapFactory.decodeFile(uri.getPath());
					Bitmap bitmap=BitmapFactory.decodeFile(uri.getPath(),getBitmapOption(2)); //将图片的长和宽缩小味原来的1/2
					this.bitmap = bitmap;
					civ_head.setImageBitmap(bitmap); 
			}

		} else if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA) {
			Uri uri = data.getData();
			if (uri == null) {
				// use bundle to get data
				Bundle bundle = data.getExtras();
				if (bundle != null) {
					Bitmap photo = (Bitmap) bundle.get("data"); // get
																// bitmap
					// spath :生成图片取个名字和路径包含类型
					this.bitmap = photo;
					civ_head.setImageBitmap(photo);
					
					Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {  
					    @Override  
					    public void onGenerated(Palette palette) {  
					         Palette.Swatch vibrant =  palette.getVibrantSwatch();  
					          if (vibrant != null) {  
					        	  
					        	  /*
					        	   * 
									    Vibrant(充满活力的)
									    Vibrant dark(充满活力的黑)
									    Vibrant light(充满活力的亮)
									    Muted(柔和的)
									    Muted dark(柔和的黑)
									    Muted lighr(柔和的亮)
					        	   */
					              // If we have a vibrant color  
					              // update the title TextView  
					        	/*  ll_bg.setBackgroundColor(vibrant.getRgb());  */
					        	  if (isMark) {
					        		  isMark = false;
					        		  ll_bg.setBackgroundColor(vibrant.getRgb()); 
					        	  }else{
					        		  isMark = true;
					        		  ll_bg.setBackgroundColor(vibrant.getTitleTextColor());  
					        	  }
					          }  
					    }  
					});
					
					// saveImage(photo,capturePath);
				} else {
					Toast.makeText(getApplicationContext(), "err****",
							Toast.LENGTH_LONG).show();
					return;
				}
			} else {
				// to do find the path of pic by uri
			}
		}

	}
	
	private Options getBitmapOption(int inSampleSize){
	        System.gc();
	        Options options = new Options();
	        options.inPurgeable = true;
	        options.inSampleSize = inSampleSize;
	        return options;
	}

	public static boolean saveImage(Bitmap photo, String spath) {
		try {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(spath, false));
			photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
