package com.von.voncat.module.ui.card.cardui.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.ui.card.cardui.Card;


public class MyCard extends Card {

	public MyCard(String title){
		super(title);
	}

	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.card_ex, null);

		((TextView) view.findViewById(R.id.title)).setText(title);

		
		return view;
	}

	
	
	
}
