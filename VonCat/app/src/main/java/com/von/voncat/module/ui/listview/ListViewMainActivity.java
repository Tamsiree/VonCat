package com.von.voncat.module.ui.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.ui.listview.DragDelListView.DragDelListViewActivity;
import com.von.voncat.module.ui.adapter.ListViewUIMainAdapter;
import com.von.voncat.module.ui.model.ListViewUIMainModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewMainActivity extends Activity implements View.OnClickListener{
    private ListView listView_listview_main;
    private List<ListViewUIMainModel> list = new ArrayList<ListViewUIMainModel>();
    private LinearLayout ll_back;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list_view_main);
        // 透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initView();//初始化控件 - FindViewById之类的操作
        initData();//初始化控件的数据及监听事件
    }

    private void initData() {
        // TODO Auto-generated method stub
        list.clear();
        list.add(new ListViewUIMainModel("DragDelListView", DragDelListViewActivity.class, "listView侧滑删除", null));
        listView_listview_main.setAdapter(new ListViewUIMainAdapter(this, list));
    }

    private void initView() {
        // TODO Auto-generated method stub
        listView_listview_main = (ListView) findViewById(R.id.listView_listview_main);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        ll_back.setVisibility(View.VISIBLE);
        ll_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("ListView特效");
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
