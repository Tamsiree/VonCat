package com.von.voncat.module.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.von.voncat.R;
import com.von.voncat.module.contact.adapter.ContactListViewAdapter;
import com.von.voncat.module.contact.model.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends Activity implements View.OnClickListener{
    private ListView listView_contact;
    private List<ContactModel> list = new ArrayList<ContactModel>();
    private LinearLayout ll_back;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_contact);
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
        listView_contact = (ListView) findViewById(R.id.listView_contact);
        ll_back = (LinearLayout) findViewById(R.id.ll_back);
        ll_back.setVisibility(View.VISIBLE);
        ll_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("联系我们");
    }

    private void initData() {
        list.clear();
        list.add(new ContactModel("Email", initIntent(),  "调用系统软件发送邮件", R.drawable.icon_mail+""));
        listView_contact.setAdapter(new ContactListViewAdapter(this, list));
    }

    private Intent initIntent(){
        Intent email = new Intent(android.content.Intent.ACTION_SEND);
        email.setType("plain/text");
        String[] emailReciver = new String[]{"voncar100@gmail.com", "voncat@126.com"};
        String emailSubject = "用户反馈";
        String emailBody = "反馈如下\n";

        //设置邮件默认地址
        email.putExtra(android.content.Intent.EXTRA_EMAIL, emailReciver);
        //设置邮件默认标题
        email.putExtra(android.content.Intent.EXTRA_SUBJECT, emailSubject);
        //设置要默认发送的内容
        email.putExtra(android.content.Intent.EXTRA_TEXT, emailBody);
        //调用系统的邮件系统
       // startActivity(Intent.createChooser(email, "请选择邮件发送软件"));

        return email;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
        }
    }
}
