package com.example.huadong.recycleView;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.activity.ChoiceActivity;
import com.example.huadong.been.CallBack;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.been.ToolsTestData;

import java.util.ArrayList;
import java.util.List;

public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ViewHolder> {
    private Context mcontext;
    private PartsTestData result;
    private CallBack callBack;




    List<ToolsTestData> list = new ArrayList<>();
    private final int REQUEST_CODE = 1;

    public ToolsAdapter(List<ToolsTestData> list, Context context) {
        this.list = list;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ToolsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycle_start_tool, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToolsAdapter.ViewHolder holder, int position) {
//        if (callBack != null) {
//            callBack.dataTo(result);
//        }
        int i = position;
        ToolsTestData current = list.get(position);
        String name = current.getText();
        holder.textView.setText(name);
        holder.imageView.setImageResource(current.getImages());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, ChoiceActivity.class);
                intent.putExtra("judgment", name);
                intent.putExtra("position", i);
                Activity activity = (Activity) mcontext;
                activity.startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView2;
        Button button;
        ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tools_img);
            textView = itemView.findViewById(R.id.tools_title);
            button = itemView.findViewById(R.id.tools_btn);
            constraintLayout = itemView.findViewById(R.id.item);
            textView2 =itemView.findViewById(R.id.price);
        }

        public void upData(PartsTestData partsTestData) {

            //更新recycleView中的对应项内容
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams1 =textView2.getLayoutParams();
            layoutParams.height = 100;
            layoutParams1.height =100;
//            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//            textView.measure(widthMeasureSpec, heightMeasureSpec);
//            int width = textView.getMeasuredWidth();
//            layoutParams.width = width;
            textView.setLayoutParams(layoutParams);
            textView2.setLayoutParams(layoutParams1);
            textView.setX(250);
            textView2.setX(450);
            textView2.setY(30);
//            textView.post(new Runnable() {
//                @Override
//                public void run() {
//                    int width = (int)textView.getPaint().measureText(textView.getText().toString());
//                    textView.setWidth((int) width);
//                }
//            });
            textView.setText(partsTestData.getPartName());
            textView2.setText(partsTestData.getPartPrice()+"");
            textView2.setTextColor(Color.parseColor("#FF0000"));
            ViewGroup.LayoutParams img = imageView.getLayoutParams();
            img.width = 100;
            img.height = 100;
            imageView.setImageResource(partsTestData.getPartImage());
        }
    }
}
