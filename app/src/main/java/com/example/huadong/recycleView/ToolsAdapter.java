package com.example.huadong.recycleView;


import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.activity.ChoiceActivity;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.been.ToolsTestData;

import java.util.ArrayList;
import java.util.List;

public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.ViewHolder> {
    private Context mcontext;
    private PartsTestData result;

    List<ToolsTestData> list = new ArrayList<>();
    private final int REQUEST_CODE = 1;

    public ToolsAdapter(List<ToolsTestData> list, Context context, PartsTestData result) {
        this.list = list;
        this.mcontext = context;
        this.result = result;

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

        ToolsTestData current = list.get(position);

        String name = current.getText();
        holder.textView.setText(name);
        holder.imageView.setImageResource(current.getImages());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, ChoiceActivity.class);
                intent.putExtra("judgment", name);
                Activity activity = (Activity) mcontext;
                activity.startActivityForResult(intent, REQUEST_CODE);
                
            }
        });
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//         String result = data.getExtras().getString("result");//得到新Activity 关闭后返回的数
//    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tools_img);
            textView = itemView.findViewById(R.id.tools_title);
            button = itemView.findViewById(R.id.tools_btn);
        }
    }
}
