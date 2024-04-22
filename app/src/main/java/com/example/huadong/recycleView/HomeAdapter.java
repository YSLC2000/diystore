package com.example.huadong.recycleView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.activity.RecommendActivity;
import com.example.huadong.been.HomeTestData;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.myViewHodler> {
    private Context mcontext;
    List<HomeTestData> list = new ArrayList<>();

    public HomeAdapter(List<HomeTestData> list, Context context) {
        this.list = list;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public HomeAdapter.myViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycle_home, parent, false);
        return new myViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.myViewHodler holder, int position) {
        HomeTestData homeTestData = list.get(position);
        holder.title.setText(homeTestData.getHomeTitle());
        holder.imageView.setImageResource(homeTestData.getHomeImage());
        holder.day.setText(homeTestData.getHomeDay());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, RecommendActivity.class);
                intent.putExtra("name",homeTestData.getHomeTitle());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHodler extends RecyclerView.ViewHolder {
        TextView title, day, num;
        ImageView imageView;

        public myViewHodler(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.home_title);
            day = itemView.findViewById(R.id.home_day);
            imageView = itemView.findViewById(R.id.home_image);
        }
    }
}
