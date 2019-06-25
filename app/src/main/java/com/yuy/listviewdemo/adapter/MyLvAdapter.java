package com.yuy.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuy.listviewdemo.R;
import com.yuy.listviewdemo.bean.userBean;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/24 22:10
 */
public class MyLvAdapter extends BaseAdapter{

    private Context mContext;
    private List<userBean> userBeans;
     private View.OnClickListener deLis;


    /**
     *定义监听接口
     */
    public void setOnDelItem(View.OnClickListener onDelItem) {
        this.deLis = onDelItem;
    }


    public MyLvAdapter(Context context, List<userBean> list){
          this.mContext = context;
          this.userBeans = list;

    }


    @Override
    public int getCount() {
        return  userBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.lv_item, null);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv);
            viewHolder.btn = view.findViewById(R.id.btn);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(userBeans.get(i).name);
        viewHolder.imageView.setImageResource(R.mipmap.iv1);

        return view;
    }


    static class ViewHolder{
      public   TextView textView;
       public   ImageView imageView;
      public      Button btn;
    }

}
