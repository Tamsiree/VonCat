package com.von.voncat.module.ui.dialog.DialogLoadingProgressAcfunVideo;

import java.util.Random;

import com.von.voncat.R;
import com.von.voncat.module.ui.dialog.TransparentDialog;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DialogLoadingProgressAcfunVideo extends TransparentDialog {
	private ProgressBar loading_progressBar;
	private TextView tv_reminder;
	private String [] loadingText = {"对的，坚持；错的，放弃！","你若安好，便是晴天。","走得太快，灵魂都跟不上了。","生气是拿别人的错误惩罚自己。","让未来到来，让过去过去。","每一种创伤，都是一种成熟。"};
	public ProgressBar getLoading_progressBar() {
		return loading_progressBar;
	}

	public TextView getTv_reminder() {
		return tv_reminder;
	}

	public DialogLoadingProgressAcfunVideo(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		View dialogView1 = LayoutInflater.from(context).inflate(
				R.layout.dialog_loading_progress_acfun_video, null);
		loading_progressBar = (ProgressBar) dialogView1
				.findViewById(R.id.loading_progressBar);
		Random r = new Random();
		int n2 = r.nextInt(loadingText.length);

		n2 = Math.abs(r.nextInt() % loadingText.length);
		tv_reminder = (TextView) dialogView1
				.findViewById(R.id.tv_reminder);
		tv_reminder.setText(loadingText[n2]);
		setContentView(dialogView1);
		getAttr().gravity = Gravity.CENTER;
	}

}
