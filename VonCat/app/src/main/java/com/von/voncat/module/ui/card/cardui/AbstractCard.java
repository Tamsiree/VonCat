package com.von.voncat.module.ui.card.cardui;

import android.content.Context;
import android.view.View;

public abstract class AbstractCard {

	protected String title;
	
	protected int image;
	
	protected String desc;
	
	public abstract View getView(Context context);
	
	public abstract View getView(Context context, boolean swipable);
	
	
	public String getTitle() {
		return title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getImage() {
		return image;
	}
	
}
