package com.example.huadong.recycleView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.activity.CommentActivity;
import com.example.huadong.been.DisplayListTestData;
import com.example.huadong.been.DisplayTestData;
import com.example.huadong.been.OrderData;

import java.util.ArrayList;
import java.util.List;

public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.myViewHodler> {
    Context context;
    private List<DisplayTestData> list =new ArrayList<>();
    public DisplayAdapter(List line,Context context){
        this.list=line;
        this.context=context;
    }
    public void setDisplayAdapter(List<DisplayTestData> list, Context context) {
        this.list = list;
        this.context=context;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DisplayAdapter.myViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.recycle_display,parent,false);
        return new myViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayAdapter.myViewHodler holder, int position) {
        DisplayTestData displayTestData =list.get(position);
        List<DisplayListTestData> displayListTestData =displayTestData.getDisplay_img();
        holder.display_user_avatar.setImageResource(displayTestData.getDisplay_avatar());
        holder.display_user_name.setText(displayTestData.getDisplay_userName());
        holder.display_user_title.setText(displayTestData.getDisplay_title());
        holder.display_user_price.setText(displayTestData.getDisplay_user_price());
        holder.display_user_ThumbsUp.setText(displayTestData.getDisplay_user_ThumbsUpNun()+"");
        holder.childRecycle.setAdapter(new DisplayListAdapter(displayListTestData));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, CommentActivity.class);
                intent.putExtra("username",displayTestData.getDisplay_userName());
                intent.putExtra("ordername",displayTestData.getDisplay_title());
                Activity activity = (Activity) context;
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class myViewHodler extends  RecyclerView.ViewHolder{
        ImageView display_user_avatar,display_img;
        TextView display_user_name,display_user_title,display_user_price,display_user_ThumbsUp;
        RecyclerView childRecycle;

        public myViewHodler(@NonNull View itemView) {
            super(itemView);
            display_user_avatar=itemView.findViewById(R.id.display_user_avatar);
            display_user_name=itemView.findViewById(R.id.display_user_name);
            display_user_title=itemView.findViewById(R.id.display_user_title);
            display_user_price=itemView.findViewById(R.id.display_user_price);
            display_user_ThumbsUp=itemView.findViewById(R.id.display_user_ThumbsUpNun);
            childRecycle =itemView.findViewById(R.id.display_recycleView_img);
            childRecycle.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));


        }
    }



//    public shareItemListener mShareItemListener;
//    public void setShareItemListener(shareItemListener mShareItemListener) {
//        this.mShareItemListener = mShareItemListener;
//    }
//
//    public interface shareItemListener{
//        void flush(DisplayTestData displayTestData,int position);
//
//    }
}
