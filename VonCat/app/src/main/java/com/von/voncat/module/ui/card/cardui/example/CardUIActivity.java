package com.von.voncat.module.ui.card.cardui.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.function.WebViewBaseActivity;
import com.von.voncat.module.ui.card.cardui.CardStack;
import com.von.voncat.module.ui.card.cardui.CardView;

public class CardUIActivity extends Activity  implements OnClickListener{

	private CardView mCardView;
	private LinearLayout ll_back;
	private TextView tv_title;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_cardui);
		// 透明状态栏
		getWindow()
				.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		// 透明导航栏
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

		initView();

		initData();
	}

	private void initView() {
		// init CardView
		mCardView = (CardView) findViewById(R.id.cardsview);
		mCardView.setSwipeable(false);
		ll_back = (LinearLayout) findViewById(R.id.ll_back);
		ll_back.setVisibility(View.VISIBLE);
		ll_back.setOnClickListener(this);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText("CardUI View");
	}

	private void initData() {
		// add AndroidViews Cards
		mCardView.addCard(new MyCard("Get the CardsUI view"));
		mCardView.addCardToLastStack(new MyCard("for Android at"));
		MyCard androidViewsCard = new MyCard("http://www.oschina.net/");
		androidViewsCard.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				/*
				 * Intent intent = new Intent(Intent.ACTION_VIEW);
				 * intent.setData(Uri.parse("http://www.androidviews.net/"));
				 * startActivity(intent);
				 */
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.putExtra("URL", "http://www.oschina.net/");
				intent.setClass(CardUIActivity.this, WebViewBaseActivity.class);
				startActivity(intent);

			}
		});
		mCardView.addCardToLastStack(androidViewsCard);

		// add one card, and then add another one to the last stack.
		mCardView.addCard(new MyCard("2 cards"));
		mCardView.addCardToLastStack(new MyCard("2 cards"));

		// add one card
		mCardView.addCard(new MyImageCard("Nexus 4 Part 1", R.drawable.icon_ui));
		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 2",
				R.drawable.icon_ui));
		mCardView.addCardToLastStack(new MyImageCard("Nexus 4 Part 3",
				R.drawable.icon_ui));

		// create a stack
		CardStack stack = new CardStack();
		stack.setTitle("title test");

		// add 3 cards to stack
		stack.add(new MyCard("3 cards"));
		stack.add(new MyCard("3 cards"));
		stack.add(new MyCard("3 cards"));

		// add stack to cardView
		mCardView.addStack(stack);

		// draw cards
		mCardView.refresh();
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
