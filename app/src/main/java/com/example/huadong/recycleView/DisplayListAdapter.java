package com.example.huadong.recycleView;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
    Context context;

    public DisplayListAdapter(List line,Context context) {
        this.list = line;
        this.context =context;
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
        Drawable drawable = context.getResources().getDrawable(displayListTestData.getImg());
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        holder.imageView.setImageResource(displayListTestData.getImg());
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                bigImageLoader(bitmap);
                return false;
            }
        });
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
    private void bigImageLoader(Bitmap bitmap){
        final Dialog dialog = new Dialog(context);
        ImageView image = new ImageView(context);
        image.setImageBitmap(bitmap);
        dialog.setContentView(image);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.cancel();
            }
        });
    }
}
