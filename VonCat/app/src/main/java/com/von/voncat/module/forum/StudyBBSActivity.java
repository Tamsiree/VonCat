package com.von.voncat.module.forum;

import android.app.Activity;
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

public class StudyBBSActivity extends Activity implements View.OnClickListener{
    private ListView listView_studyBBS;
    private List<ListViewWebViewMainModel> list = new ArrayList<ListViewWebViewMainModel>();
    private LinearLayout ll_back;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_study_bbs);
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
        listView_studyBBS = (ListView) findViewById(R.id.listView_studyBBS);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        ll_back.setVisibility(View.VISIBLE);
        ll_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("学习论坛");
    }

    private void initData() {
        list.clear();
        list.add(new ListViewWebViewMainModel("深度开源", WebViewBaseActivity.class, "http://www.open-open.com/news/view/193e7e2", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("开源中国", WebViewBaseActivity.class, "http://www.oschina.net/android", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("博客园", WebViewBaseActivity.class, "http://www.cnblogs.com/cate/android/", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("AndroidDevTools", WebViewBaseActivity.class, Constant.URL_ANDROIDDEVTOOLS, "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("CSDN", WebViewBaseActivity.class, "http://blog.csdn.net/mobile/index.html", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("知乎", WebViewBaseActivity.class, "https://www.zhihu.com/topic/19603145", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("极分享", WebViewBaseActivity.class, "http://finalshares.com/tag-Android%E5%8A%9F%E8%83%BD", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("V2EX", WebViewBaseActivity.class, "https://www.v2ex.com/go/android", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("IT蓝豹", WebViewBaseActivity.class, "http://www.itlanbao.com/", "", R.drawable.icon_bbs+""));
        list.add(new ListViewWebViewMainModel("EOE", WebViewBaseActivity.class, "http://www.eoeandroid.com/forum.php?gid=3", "", R.drawable.icon_bbs+""));



        listView_studyBBS.setAdapter(new ListViewWebViewMainAdapter(this, list));
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
