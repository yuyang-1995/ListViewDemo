package com.yuy.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yuy.listviewdemo.adapter.MyLvAdapter;
import com.yuy.listviewdemo.bean.userBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private ListView listView;
    private List<userBean> userBeans;
    View headView, footerView;
    MyLvAdapter myLvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userBeans = new ArrayList<userBean>();
        initValue();

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
         headView = inflater.inflate(R.layout.head, null);
         footerView = inflater.inflate(R.layout.footer, null);
         initView();
    }

    //初始化值
    private void initValue() {

        for (int i=0; i<10; i++){
            userBean userBean = new userBean();
            userBean.name = "第" + (1+i)  + "位用户！";
            userBean.iv = "R.mipami";
            userBeans.add(userBean);
        }
    }

    private void initView() {

        listView = findViewById(R.id.lv);
        //添加头布局 脚布局
        listView.addHeaderView(headView);
        listView.addFooterView(footerView);

        myLvAdapter = new MyLvAdapter(MainActivity.this,userBeans);



        listView.setAdapter(myLvAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "您点击了第" + (i+1) + "项", Toast.LENGTH_SHORT).show();
            }
        });

    }


//    @Override
//    public void click(View v) {
//
//        int i = (int) v.getTag();
//        userBeans.remove(i);
//        myLvAdapter.notifyDataSetChanged();
//}


}
