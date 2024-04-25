package com.example.huadong.activity;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huadong.R;
import com.example.huadong.been.CallBack;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.been.ToolsTestData;
import com.example.huadong.been.UserInfo;
import com.example.huadong.recycleView.ToolsAdapter;
import com.example.huadong.untils.OrderDataBase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ToolsActivity extends AppCompatActivity {
    private PartsTestData result;
    private ArrayList<ToolsTestData> arrayList = new ArrayList<>();
    public RecyclerView mToolsRecycleView;
    public ToolsAdapter toolsAdapter = new ToolsAdapter(arrayList, this);
    private ImageView back_btn;
    private TextView btn_finish;
    private OrderDataBase orderDataBase;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        btn_finish = findViewById(R.id.btn_finish);
        editText = findViewById(R.id.tool_name);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo = UserInfo.getsUserInfo();
                if (userInfo != null) {

                }
                List<String> list = new ArrayList<>();
                //这个集合是为了合计订单价格list_price
                List<String> list_price =new ArrayList<>();
//                Log.d("json数据查看", jsonObject.toString());
//                Log.d("json数据获取", test);
                TextView textView, tv_price;
                ImageView imageView;
                String text = "false", drawable = "false";
                String price = null;
                int settlement=0;

                for (int i = 0; i < toolsAdapter.getItemCount(); i++) {
                    RecyclerView.ViewHolder viewHolder = mToolsRecycleView.findViewHolderForAdapterPosition(i);
                    if (viewHolder instanceof ToolsAdapter.ViewHolder) {
                        ToolsAdapter.ViewHolder viewHolder1 = (ToolsAdapter.ViewHolder) viewHolder;
                        textView = viewHolder1.itemView.findViewById(R.id.tools_title);
                        imageView = viewHolder1.itemView.findViewById(R.id.tools_img);
                        tv_price = viewHolder1.itemView.findViewById(R.id.price);
                        text = textView.getText().toString();
                        price =tv_price.getText().toString();
                        settlement=Integer.valueOf(price)+settlement;
                        Log.d("settlement",settlement+"");
                        list.add(text);
                    }
                }
                JSONObject order_list = new JSONObject();
                try {
                    order_list.put("cpu", list.get(0).toString());
                    order_list.put("mianboard", list.get(1).toString());
                    order_list.put("graphics", list.get(2).toString());
                    order_list.put("memorysticks", list.get(3).toString());
                    order_list.put("power", list.get(4).toString());
                    order_list.put("harddisk", list.get(5).toString());
                    order_list.put("radiator", list.get(6).toString());
                    order_list.put("chassis", list.get(7).toString());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JSONObject jsonObject = new JSONObject();
                String test = "1";

                try {
                    jsonObject.put("order_id", "测试订单");
                    jsonObject.put("order_name", order_list);
                    JSONObject jsonObject1 = jsonObject.getJSONObject("order_name");
                    test = jsonObject1.getString("cpu");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String sysTime = String.valueOf(System.currentTimeMillis());
                String order_name = editText.getText().toString();
                String user_id = UserInfo.sUserInfo.getUsername();
                String cpu = list.get(0).toString();
                String mainBoard = list.get(1).toString();
                String graphics = list.get(2).toString();
                String memorySticks = list.get(3).toString();
                String power = list.get(4).toString();
                String hardDisk = list.get(5).toString();
                String radiator = list.get(6).toString();
                String chassis = list.get(7).toString();
                if (!order_name.isEmpty()) {
                    int row = OrderDataBase.getInstance(ToolsActivity.this).addOrders(user_id, sysTime, order_name, cpu, mainBoard, graphics, memorySticks, power, hardDisk, radiator, chassis, settlement);
                    if (row > 0) {
                        Toast.makeText(ToolsActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ToolsActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                } else {
                    Toast.makeText(ToolsActivity.this, "标题不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mToolsRecycleView = findViewById(R.id.recyclerView);
        mToolsRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mToolsRecycleView.setAdapter(toolsAdapter);

        DividerItemDecoration mDiv = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mToolsRecycleView.addItemDecoration(mDiv);
        back_btn = findViewById(R.id.tools_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DataInit();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // 处理从 ResultActivity 返回的结果
                result = (PartsTestData) data.getSerializableExtra("back");
                Integer position = data.getIntExtra("backPosition", 0);
                Toast.makeText(this, result + "添加成功", Toast.LENGTH_SHORT).show();
                Log.d("backPosition", position.toString());
                Log.d("backPosition", result.toString());
                ToolsAdapter.ViewHolder viewHolder = (ToolsAdapter.ViewHolder) mToolsRecycleView.findViewHolderForAdapterPosition(position);
                if (viewHolder instanceof ToolsAdapter.ViewHolder) {
                    ToolsAdapter.ViewHolder custer = (ToolsAdapter.ViewHolder) viewHolder;
                    custer.upData(result);
                }
            } else if (resultCode == RESULT_CANCELED) {
                // 处理用户取消操作
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void DataInit() {
        ToolsTestData toolsTestData = new ToolsTestData();
        toolsTestData.setImages(R.drawable.cpu);
        toolsTestData.setText("CPU");
        ToolsTestData toolsTestData1 = new ToolsTestData();
        toolsTestData1.setImages(R.drawable.mainboard);
        toolsTestData1.setText("主板");
        ToolsTestData toolsTestData2 = new ToolsTestData();
        toolsTestData2.setImages(R.drawable.graphics);
        toolsTestData2.setText("显卡");
        ToolsTestData toolsTestData3 = new ToolsTestData();
        toolsTestData3.setImages(R.drawable.memorysticks);
        toolsTestData3.setText("内存");
        ToolsTestData toolsTestData4 = new ToolsTestData();
        toolsTestData4.setImages(R.drawable.power);
        toolsTestData4.setText("电源");
        ToolsTestData toolsTestData5 = new ToolsTestData();
        toolsTestData5.setImages(R.drawable.harddisk);
        toolsTestData5.setText("硬盘");
        ToolsTestData toolsTestData6 = new ToolsTestData();
        toolsTestData6.setImages(R.drawable.radiator);
        toolsTestData6.setText("散热");
        ToolsTestData toolsTestData7 = new ToolsTestData();
        toolsTestData7.setImages(R.drawable.chassis);
        toolsTestData7.setText("机箱");
        arrayList.add(toolsTestData);
        arrayList.add(toolsTestData1);
        arrayList.add(toolsTestData2);
        arrayList.add(toolsTestData3);
        arrayList.add(toolsTestData4);
        arrayList.add(toolsTestData5);
        arrayList.add(toolsTestData6);
        arrayList.add(toolsTestData7);

    }

}