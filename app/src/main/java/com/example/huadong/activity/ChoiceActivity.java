package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huadong.R;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.recycleView.PartsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends AppCompatActivity {
    private final List<PartsTestData> cpu_list = new ArrayList<>();
    private final List<PartsTestData> mianboard_list = new ArrayList<>();
    private RecyclerView recyclerView;
    private String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        DataInit();
        str = getIntent().getStringExtra("judgment");
        Log.d("chakan", str);
        PartsAdapter partsAdapter = null;
        if (str.equalsIgnoreCase("cpu")) {
            partsAdapter = new PartsAdapter(cpu_list, str, this);
        } else if (str.equals("主板")){
            partsAdapter =new PartsAdapter(mianboard_list,str,this);
        }
        TextView textView = findViewById(R.id.test);
        textView.setText(str);

        //返回之前activity的内容
//        Intent intent = new Intent();
//        intent.putExtra("back", str);
//        setResult(Activity.RESULT_OK, intent);

        recyclerView = findViewById(R.id.part_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(partsAdapter);
        DividerItemDecoration mDiv= new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDiv);

    }

    private void DataInit() {
        PartsTestData partsTestData = new PartsTestData();
        partsTestData.setPartImage(R.drawable.cpu);
        partsTestData.setPartName("cpu");
        partsTestData.setPartParameter("i9 14900k");
        partsTestData.setPartPrice(3999);
        PartsTestData cpu = new PartsTestData();
        cpu.setPartName("cpu1");
        cpu.setPartImage(R.drawable.cpu);
        cpu.setPartParameter("i5 12490f");
        cpu.setPartPrice(1099);
        PartsTestData cpu1 = new PartsTestData();
        cpu1.setPartName("cpu2");
        cpu1.setPartImage(R.drawable.cpu);
        cpu1.setPartParameter("i7 13700k");
        cpu1.setPartPrice(2999);
        cpu_list.add(partsTestData);
        cpu_list.add(cpu);
        cpu_list.add(cpu1);



        PartsTestData partsTestData1 = new PartsTestData();
        partsTestData1.setPartImage(R.drawable.mianboard);
        partsTestData1.setPartName("主板");
        partsTestData1.setPartParameter("b760m");
        partsTestData1.setPartPrice(1300);
        PartsTestData partsTestData2 = new PartsTestData();
        partsTestData2.setPartImage(R.drawable.mianboard);
        partsTestData2.setPartName("主板");
        partsTestData2.setPartParameter("z790");
        partsTestData2.setPartPrice(1800);
        mianboard_list.add(partsTestData1);
        mianboard_list.add(partsTestData2);


    }

}