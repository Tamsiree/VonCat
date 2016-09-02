package com.von.voncat.adapter;

import java.util.List;

import com.von.voncat.R;
import com.von.voncat.model.ListViewMainModel;
import com.von.voncat.utils.VonUtil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewMainAdapter extends BaseAdapter {
	private Context context;
	private List<ListViewMainModel> list;
	
	public GridViewMainAdapter(Context context, List<ListViewMainModel> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview_main, null);
		}
		TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
		TextView tv_description = (TextView) convertView.findViewById(R.id.tv_description);
		ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
		//isNumeric
		if(!VonUtil.isNullString(list.get(position).getIcon_img())){
			if (VonUtil.isNumeric(list.get(position).getIcon_img())) {
				iv_icon.setImageResource(VonUtil.StringToInt(list.get(position).getIcon_img()));
			}
		}
		iv_icon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!(list.get(position).getActivityClass() == null)){
					Intent intent = new Intent();
					intent.setClass(context, list.get(position).getActivityClass());
					context.startActivity(intent);
				}else{
					VonUtil.ShowToast(context, "请耐心等待，正在开发中", false);
				}
			}
		});
		
		tv_name.setText(list.get(position).getName());
		if(VonUtil.isNullString(list.get(position).getDescription())){
			tv_description.setVisibility(View.GONE);
		}else{
			tv_description.setVisibility(View.VISIBLE);
			tv_description.setText(list.get(position).getDescription());
		}
		tv_description.setVisibility(View.GONE);
		return convertView;
	}
}
