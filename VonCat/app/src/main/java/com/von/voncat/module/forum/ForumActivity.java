package com.von.voncat.module.forum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.function.WebViewBaseActivity;
import com.von.voncat.module.ui.adapter.ListViewUIMainAdapter;
import com.von.voncat.module.ui.model.ListViewUIMainModel;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends Activity {
    private ListView listView_forum;
    private List<ListViewUIMainModel> list = new ArrayList<ListViewUIMainModel>();
    private LinearLayout ll_back;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forum);
        // 透明状态栏
        getWindow()
                .addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initView();// 初始化控件 - FindViewById之类的操作
        initData();// 初始化控件的数据及监听事件
    }
    private void initView() {
        listView_forum = (ListView) findViewById(R.id.listView_forum);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        ll_back.setVisibility(View.VISIBLE);
        ll_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("论坛文献");
    }

    private void initData() {
        list.clear();
        list.add(new ListViewUIMainModel("学习论坛", StudyBBSActivity.class,  "", R.drawable.icon_bbs+""));
        list.add(new ListViewUIMainModel("UI设计论坛", UIBBSActivity.class,  "", R.drawable.icon_bbs+""));
        list.add(new ListViewUIMainModel("Tools论坛", WebViewBaseActivity.class,  "", R.drawable.icon_bbs+""));
        listView_forum.setAdapter(new ListViewUIMainAdapter(this, list));
    }
}
