package com.von.voncat.module.ui.viewgroup;

import android.app.Activity;
import android.os.Bundle;

public class VonViewGroupActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new VViewGroup(this));
	}
}
