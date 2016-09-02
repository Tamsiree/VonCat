package com.von.voncat.module.forum;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.von.voncat.Constant;
import com.von.voncat.R;
import com.von.voncat.module.function.WebViewBaseActivity;
import com.von.voncat.module.function.adapter.ListViewWebViewMainAdapter;
import com.von.voncat.module.function.model.ListViewWebViewMainModel;

import java.util.ArrayList;
import java.util.List;

public class UIBBSActivity extends Activity implements View.OnClickListener{
    private ListView listView_uibbs;
    private List<ListViewWebViewMainModel> list = new ArrayList<ListViewWebViewMainModel>();
    private LinearLayout ll_back;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_uibbs);
        // 透明状态栏
        getWindow()
                .addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initView();//初始化控件 - FindViewById之类的操作
        initData();//初始化控件的数据及监听事件
    }

    private void initView() {
        listView_uibbs = (ListView) findViewById(R.id.listView_uibbs);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        ll_back.setVisibility(View.VISIBLE);
        ll_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("学习论坛");
    }

    private void initData() {
        list.clear();
        list.add(new ListViewWebViewMainModel("黄蜂网", WebViewBaseActivity.class, "http://woofeng.cn/", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("UI", WebViewBaseActivity.class, "http://www.ui.cn/", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("EasyIcon", WebViewBaseActivity.class, "http://www.easyicon.net/", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("IconFont", WebViewBaseActivity.class, "http://www.iconfont.cn/", "阿里巴巴矢量图标", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("优阁", WebViewBaseActivity.class, "http://www.uigreat.com/guifan/", "Android的图标尺寸", R.drawable.icon_bbs+""));
        listView_uibbs.setAdapter(new ListViewWebViewMainAdapter(this, list));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_back:
                finish();
                break;
            default:
                break;
        }
    }
}
