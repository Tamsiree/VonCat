package com.von.voncat;


import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

public class VonApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SpeechUtility.createUtility(this, SpeechConstant.APPID +"=56f4cd01");//初始化科大讯飞SDK
	}
}
