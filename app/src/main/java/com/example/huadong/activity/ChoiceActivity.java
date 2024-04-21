package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.huadong.R;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.recycleView.PartsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends AppCompatActivity {
    private final List<PartsTestData> cpu_list = new ArrayList<>();
    private final List<PartsTestData> mianboard_list = new ArrayList<>();
    private final List<PartsTestData> graphics =new ArrayList<>();
    private RecyclerView recyclerView;
    private String str;
    private Integer position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        DataInit();
        str = getIntent().getStringExtra("judgment");
        position = getIntent().getIntExtra("position", -1);
        Log.d("TESTPOSITION", position.toString());
        PartsAdapter partsAdapter = null;
        if (str.equalsIgnoreCase("cpu")) {
            partsAdapter = new PartsAdapter(cpu_list, str, this, position);
        } else if (str.equals("主板")) {
            partsAdapter = new PartsAdapter(mianboard_list, str, this, position);
        } else if (str.equals("显卡")) {
            partsAdapter = new PartsAdapter(graphics, str, this, position);
        }
        TextView textView = findViewById(R.id.test);
        textView.setText(str);

        //  返回之前activity的内容
//        Intent intent = new Intent();
//        intent.putExtra("backPosition",position);
//        setResult(Activity.RESULT_OK, intent);


        recyclerView = findViewById(R.id.part_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(partsAdapter);
        DividerItemDecoration mDiv = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDiv);

    }

    private void DataInit() {
        PartsTestData partsTestData = new PartsTestData();
        partsTestData.setPartImage(R.drawable.i9_14900k);
        partsTestData.setPartName("i9 14900k");
        partsTestData.setPartParameter("高性能生产力cpu");
        partsTestData.setPartPrice(3999);
        PartsTestData cpu = new PartsTestData();
        cpu.setPartName("i5 12490f");
        cpu.setPartImage(R.drawable.cpu);
        cpu.setPartParameter("游戏不用愁，2k上我我能行");
        cpu.setPartPrice(1099);
        PartsTestData cpu1 = new PartsTestData();
        cpu1.setPartName("i7 13700k");
        cpu1.setPartImage(R.drawable.cpu);
        cpu1.setPartParameter("我是高级生产力");
        cpu1.setPartPrice(2999);
        cpu_list.add(partsTestData);
        cpu_list.add(cpu);
        cpu_list.add(cpu1);


        PartsTestData partsTestData1 = new PartsTestData();
        partsTestData1.setPartImage(R.drawable.mainboard);
        partsTestData1.setPartName("b760m");
        partsTestData1.setPartParameter("酷睿十二代i5板板");
        partsTestData1.setPartPrice(1300);
        PartsTestData partsTestData2 = new PartsTestData();
        partsTestData2.setPartImage(R.drawable.mainboard);
        partsTestData2.setPartName("z790");
        partsTestData2.setPartParameter("酷睿十二代i7，i9板板");
        partsTestData2.setPartPrice(1800);
        mianboard_list.add(partsTestData1);
        mianboard_list.add(partsTestData2);


        PartsTestData partsTestData3 = new PartsTestData();
        partsTestData3.setPartImage(R.drawable.nvidia_4060);
        partsTestData3.setPartName("铭瑄电竞之心");
        partsTestData3.setPartParameter("这真的是2023的甜品卡吗?");
        partsTestData3.setPartPrice(2199);

        PartsTestData partsTestData4 = new PartsTestData();
        partsTestData4.setPartImage(R.drawable.nvidia_4060);
        partsTestData4.setPartName("瑷珈4060ti");
        partsTestData4.setPartParameter("二次元甜品卡吗?");
        partsTestData4.setPartPrice(2399);

        graphics.add(partsTestData3);
        graphics.add(partsTestData4);


    }

}