package com.example.huadong.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.DisplayListTestData;

import java.util.ArrayList;
import java.util.List;

public class DisplayListAdapter extends RecyclerView.Adapter<DisplayListAdapter.myViewHold> {
    List<DisplayListTestData> list = new ArrayList<>();

    public DisplayListAdapter(List line) {
        this.list = line;
    }

    @NonNull
    @Override
    public DisplayListAdapter.myViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycle_display_img, parent, false);
        return new myViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayListAdapter.myViewHold holder, int position) {
        DisplayListTestData displayListTestData = list.get(position);
        holder.imageView.setImageResource(displayListTestData.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHold extends RecyclerView.ViewHolder {
        ImageView imageView;

        public myViewHold(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.display_recycleView_img_list);
        }
    }
}
