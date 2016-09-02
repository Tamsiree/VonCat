package com.von.voncat.module.ui.listview.DragDelListView;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.von.voncat.R;

import java.util.List;

/**
 * Created by Administrator on 2016/4/11 0011.
 */
public class DragDelListViewAdapter extends BaseAdapter {
    private Context context;
    private List<ApplicationInfo> mAppList;
    public DragDelListViewAdapter(Context context, List<ApplicationInfo> appList)
    {
        this.context = context;
        mAppList=appList;
    }
    @Override
    public int getCount() {
        return mAppList.size();
    }

    @Override
    public ApplicationInfo getItem(int position) {
        return mAppList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int loc=position;
        ViewHolder holder=null;
        View menuView=null;
        if (convertView == null) {
            convertView = View.inflate(context,
                    R.layout.swipecontent, null);
            menuView = View.inflate(context,
                    R.layout.swipemenu, null);
            //合成内容与菜单
            convertView = new DragDelItem(convertView,menuView);
            holder=new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ApplicationInfo item = getItem(position);
        holder.iv_icon.setImageDrawable(item.loadIcon(context.getPackageManager()));
        holder.tv_name.setText(item.loadLabel(context.getPackageManager()));
        holder.tv_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(context, "open:"+loc, Toast.LENGTH_SHORT).show();
            }
        });
        holder.tv_del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_open,tv_del;
        public ViewHolder(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_open=(TextView)view.findViewById(R.id.tv_open);
            tv_del=(TextView)view.findViewById(R.id.tv_del);
            view.setTag(this);
        }
    }
}
