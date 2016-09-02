package com.von.voncat.module.contact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.contact.model.ContactModel;
import com.von.voncat.utils.VonUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/4/12 0012.
 */
public class ContactListViewAdapter extends BaseAdapter {
    private Context context;
    private List<ContactModel> list;

    public ContactListViewAdapter(Context context, List<ContactModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_main, null);
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
        iv_icon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(!(list.get(position).getIntent() == null)){
                    context.startActivity(Intent.createChooser(list.get(position).getIntent(), "请选择邮件发送软件"));
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
        return convertView;
    }
}
