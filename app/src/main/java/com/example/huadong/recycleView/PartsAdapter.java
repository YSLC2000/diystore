package com.example.huadong.recycleView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.PartsTestData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.ViewHolder> {
    List<PartsTestData> list = new ArrayList<>();
    Context mcontext;
    String str;
    PartsTestData partName;

    public PartsAdapter(List<PartsTestData> list, String str, Context context) {
        this.list = list;
        this.mcontext = context;
        this.str = str;
    }

    @NonNull
    @Override
    public PartsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycle_start_tools_parts, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartsAdapter.ViewHolder holder, int position) {
        PartsTestData partsTestData = list.get(position);
        holder.partImage.setImageResource(partsTestData.getPartImage());
        holder.partName.setText(partsTestData.getPartName());
        holder.partPrice.setText(String.valueOf(partsTestData.getPartPrice()));
        holder.partParameter.setText(partsTestData.getPartParameter());
        //点击其中一项关闭当前activity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PartsTestData partsTestData = list.get(holder.getAdapterPosition());
                partName = partsTestData;
                Log.d("partName", "你点击了" + partName);
                Intent intent = new Intent();
                intent.putExtra("back", partName);
                ((Activity)mcontext).setResult(Activity.RESULT_OK, intent);
                ((Activity) mcontext).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView partImage;
        TextView partName, partParameter, partPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            partImage = itemView.findViewById(R.id.partImage);
            partName = itemView.findViewById(R.id.partsName);
            partPrice = itemView.findViewById(R.id.partPrice);
            partParameter = itemView.findViewById(R.id.partParameter);

        }
    }
}
