package com.von.voncat.module;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.adapter.GridViewMainAdapter;
import com.von.voncat.adapter.ListViewMainAdapter;
import com.von.voncat.module.contact.ContactActivity;
import com.von.voncat.module.forum.ForumActivity;
import com.von.voncat.module.function.FunctionMainActivity;
import com.von.voncat.model.ListViewMainModel;
import com.von.voncat.module.ui.UIMainActivity;
import com.von.voncat.utils.VonUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView_main;
    private GridView gridView_main;
    private TextView tv_hello_world;
    private List<ListViewMainModel> list = new ArrayList<ListViewMainModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        // 透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initView();//初始化控件 - FindViewById之类的操作
        initData();//初始化控件的数据及监听事件

    }

    private void initView() {
        // TODO Auto-generated method stub
        tv_hello_world = (TextView) findViewById(R.id.tv_hello_world);
        listView_main = (ListView) findViewById(R.id.listView_main);
        gridView_main = (GridView) findViewById(R.id.gridView_main);
    }

    private void initData() {
        // TODO Auto-generated method stub
        listView_main.setVisibility(View.GONE);
        list.clear();
        list.add(new ListViewMainModel("界面特效", UIMainActivity.class, "一个大的特效集合，一来为了查看方便，二来也为拷贝复制便捷", ""));
        list.add(new ListViewMainModel("功能效果", FunctionMainActivity.class, "", R.drawable.icon_function+""));
        list.add(new ListViewMainModel("网络请求", null, "", R.drawable.icon_network_requests+""));
        list.add(new ListViewMainModel("论坛文献", ForumActivity.class, "", R.drawable.icon_bbs+""));
        list.add(new ListViewMainModel("DEMO", null, "", R.drawable.icon_demo+""));
        list.add(new ListViewMainModel("联系我们", ContactActivity.class, "", R.drawable.icon_mail+""));
        listView_main.setAdapter(new ListViewMainAdapter(this, list));
        gridView_main.setAdapter(new GridViewMainAdapter(this, list));

        tv_hello_world.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(listView_main.isShown()){
                    listView_main.setVisibility(View.GONE);
                    gridView_main.setVisibility(View.VISIBLE);
                }else{
                    listView_main.setVisibility(View.VISIBLE);
                    gridView_main.setVisibility(View.GONE);
                }
            }
        });

    }

    private long before = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long curruttime = System.currentTimeMillis();
                if (curruttime - before < 2000) {
                } else {
                    VonUtil.ShowToast(this, "再次点击返回退出", false);
                    before = curruttime;
                    return true;
                }
                break;
        }
        // return true;
        return super.onKeyDown(keyCode, event);
    }
}
