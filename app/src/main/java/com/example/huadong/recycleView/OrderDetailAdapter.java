package com.example.huadong.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.OrderTestData;


import java.util.ArrayList;
import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {
    List<String> list =new ArrayList<>();
    Context context;

    public OrderDetailAdapter(Context content, List<String> list){
        this.list=list;
        this.context =content;
    }
    @NonNull
    @Override
    public OrderDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycle_order_details,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailAdapter.ViewHolder holder, int position) {
         String name =list.get(position);
         holder.partName.setText(name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView partName,partParameter,partPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.part_img);
            partName=itemView.findViewById(R.id.part_name);
            partParameter=itemView.findViewById(R.id.part_parameter);
            partPrice=itemView.findViewById(R.id.part_price);
        }
    }
}
