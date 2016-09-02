package com.zbar.lib;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.dtr.zbar.build.ZBarDecoder;
import com.von.voncat.R;
import com.von.voncat.module.function.ScannerCode.ScanerCodeActivity;


/**
 * 描述: 接受消息后解码
 */
final class DecodeHandler extends Handler {

	ScanerCodeActivity activity = null;

	DecodeHandler(ScanerCodeActivity activity) {
		this.activity = activity;
	}

	@Override
	public void handleMessage(Message message) {
		switch (message.what) {
		case R.id.decode:
			decode((byte[]) message.obj, message.arg1, message.arg2);
			break;
		case R.id.quit:
			Looper.myLooper().quit();
			break;
		}
	}

	private void decode(byte[] data, int width, int height) {
		byte[] rotatedData = new byte[data.length];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				rotatedData[x * height + height - y - 1] = data[x + y * width];
		}
		int tmp = width;// Here we are swapping, that's the difference to #11
		width = height;
		height = tmp;

		ZbarManager manager = new ZbarManager();
		String result = manager.decode(rotatedData, width, height, true,
				activity.getX(), activity.getY(), activity.getCropWidth(),
				activity.getCropHeight());
		ZBarDecoder zBarDecoder = new ZBarDecoder();
		String result_line = zBarDecoder.decodeRaw(rotatedData,width,height);
		if (result != null) {
			if(null != activity.getHandler()){
				Message msg = new Message();
				msg.obj = "二维码:"+result;
				msg.what = R.id.decode_succeeded;
				activity.getHandler().sendMessage(msg);
			}
		} else {
			if(result_line != null){
				if(null != activity.getHandler()){
					Message msg = new Message();
					msg.obj = "条形码:"+result_line;
					msg.what = R.id.decode_succeeded;
					activity.getHandler().sendMessage(msg);
				}
			}else{
				if (null != activity.getHandler()) {
					activity.getHandler().sendEmptyMessage(R.id.decode_failed);
				}
			}
			//Toast.makeText(activity, result_line, 0).show();
		}
	}

}
