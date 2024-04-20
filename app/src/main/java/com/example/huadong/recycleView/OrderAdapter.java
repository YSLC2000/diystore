package com.example.huadong.recycleView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.activity.OrderDetailsActivity;
import com.example.huadong.been.OrderData;
import com.example.huadong.been.OrderTestData;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myViewHodler> {
    List<OrderData> list = new ArrayList<>();
    Context context;

    public void setOrderAdapter(List<OrderData> list,Context context) {
        this.list = list;
        this.context=context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderAdapter.myViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycle_user_order, parent,false);
        return new myViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.myViewHodler holder, int position) {
//        String str =list.get(position);
       OrderData orderData =list.get(position);
       holder.textView.setText(orderData.getOrder_name());
       Integer i =orderData.getOrder_price();
       holder.textView_price.setText(i.toString());
       holder.textView_time.setText(orderData.getOrder_time());
       holder.btn_manage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mOnItemClickListener!=null){
                   showPopupMenu(v,orderData,position);

               }

           }
       });
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(null!=mOnItemClickListener){
                   mOnItemClickListener.onItemClick(orderData,position);
               }
           }
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHodler extends RecyclerView.ViewHolder {
        TextView textView,textView_price,textView_time;
        ImageView imageView;
        Button btn_manage;

        public myViewHodler(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.order_id);
            textView_price = itemView.findViewById(R.id.order_price);
            textView_time =itemView.findViewById(R.id.order_time);
            btn_manage =itemView.findViewById(R.id.btn_manage);
        }
    }



    private onItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface onItemClickListener{
        //详情页面数据传输监听
        void onItemClick(OrderData orderData,int position);
        //删除订单监听
        int delete(OrderData orderData,int position);
        //加入分享页面监听
        int share(OrderData orderData,int position);
    }
    @SuppressLint("RestrictedApi")
    public void showPopupMenu(View view,OrderData orderData,int position){
        PopupMenu popupMenu = new PopupMenu(context, view);
        // 获取布局文件
        popupMenu.getMenuInflater().inflate(R.menu.sample_menu, popupMenu.getMenu());
        //显示PopupMenu
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                    if(item.getItemId()==R.id.delete){
                        int i= mOnItemClickListener.delete(orderData,position);
                        if(i>0){
                            Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context,"删除失败",Toast.LENGTH_SHORT).show();
                        }

                    }else if(item.getItemId()==R.id.share){
                        int row =mOnItemClickListener.share(orderData,position);
                        if(row>0){
                            Toast.makeText(context,"分享成功",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context,"分享失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                return true;
            }
        });
    }
}
