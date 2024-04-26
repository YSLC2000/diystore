package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.huadong.R;
import com.example.huadong.been.OrderData;
import com.example.huadong.been.UserInfo;
import com.example.huadong.recycleView.OrderDetailAdapter;
import com.example.huadong.untils.OrderDataBase;

import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    OrderDetailAdapter orderDetailAdapter;
    Toolbar toolbar;
    TextView order_price;
    Button settlement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_order_details);
        toolbar=findViewById(R.id.order_back);
        order_price=findViewById(R.id.order_price);
        settlement=findViewById(R.id.settlement);
        ImageView img =new ImageView(this);
        img.setImageResource(R.drawable.ewm);
//        View view = LayoutInflater.from(OrderDetailsActivity.this).inflate(R.layout.dialog_settlement,null);
//        TextView textView =view.findViewById(R.id.settlement_name);
//        textView.setText(UserInfo.sUserInfo.getUsername());
        settlement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  new AlertDialog.Builder(OrderDetailsActivity.this)
                          .setTitle("支付页面")
                          .setView(img)
                          .setNegativeButton("确认",null)
                          .show();

            }
        });
        OrderData orderData =(OrderData) getIntent().getSerializableExtra("orderData");
        List<String> list = OrderDataBase.getInstance(this).selectPart(orderData.getOrder_name());
        Log.d("OrderDetailsActivitySSS",list.toString());
        order_price.setText(String.valueOf(orderData.getOrder_price()));
        orderDetailAdapter = new OrderDetailAdapter(this, list);
        recyclerView = findViewById(R.id.part_order);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderDetailAdapter);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        toolbar.setTitle(orderData.getOrder_name());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}