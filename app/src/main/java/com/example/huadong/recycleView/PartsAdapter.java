package com.example.huadong.recycleView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.untils.BottomUpDialog;
import com.example.huadong.untils.OrderDataBase;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.ViewHolder> {
    List<PartsTestData> list = new ArrayList<>();
    Context mcontext;
    String str;
    PartsTestData partName;
    int backPosition;

    public PartsAdapter(List<PartsTestData> list, String str, Context context, int backPosition) {
        this.list = list;
        this.mcontext = context;
        this.str = str;
        this.backPosition = backPosition;
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
        Context context = holder.itemView.getContext();
        PartsTestData partsTestData = list.get(position);
        holder.partImage.setImageResource(partsTestData.getPartImage());
        holder.partName.setText(partsTestData.getPartName());
        holder.partPrice.setText(String.valueOf(partsTestData.getPartPrice()));
        holder.partParameter.setText(partsTestData.getPartParameter());
//        点击其中一项关闭当前activity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PartsTestData partsTestData = list.get(holder.getAdapterPosition());
                partName = partsTestData;
                Log.d("partName", "你点击了" + partName);
                Intent intent = new Intent();
                intent.putExtra("back", partName);
                intent.putExtra("backPosition",backPosition);
                ((Activity) mcontext).setResult(Activity.RESULT_OK, intent);
                ((Activity) mcontext).finish();

            }
        });
        holder.argument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog =new BottomSheetDialog(mcontext);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.dialog_bottom_new,null);
                TextView textView = view.findViewById(R.id.parts_name);
                TextView partParameter =view.findViewById(R.id.detail);
                PartsTestData partsTestData = list.get(holder.getAdapterPosition());
                //通过名字在数据库中获取其他参数
                String name =partsTestData.getPartName();
//                Log.d("partsTestData_name",name);
                PartsTestData data_partsTestData=OrderDataBase.getInstance(mcontext).partsArgument(name);
                if(data_partsTestData!=null){
                    Log.d("partsTestData_name",data_partsTestData.getPartParameter());
                    textView.setText(name);
                    partParameter.setText(data_partsTestData.getPartParameter());
                    bottomSheetDialog.setContentView(view);
                    bottomSheetDialog.show();
                }else {
                    Toast.makeText(mcontext,"没有找到数据",Toast.LENGTH_SHORT).show();
                }
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
        Button argument;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            partImage = itemView.findViewById(R.id.partImage);
            partName = itemView.findViewById(R.id.partsName);
            partPrice = itemView.findViewById(R.id.partPrice);
            partParameter = itemView.findViewById(R.id.partParameter);
            argument =itemView.findViewById(R.id.argument);
        }
    }


}
