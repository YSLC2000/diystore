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
    private final List<PartsTestData> memorysticks =new ArrayList<>();
    private final List<PartsTestData> power =new ArrayList<>();
    private final List<PartsTestData> harddisk =new ArrayList<>();
    private final List<PartsTestData> radiator =new ArrayList<>();
    private final List<PartsTestData> chassis =new ArrayList<>();
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
        } else if (str.equals("内存")) {
            partsAdapter = new PartsAdapter(memorysticks, str, this, position);
        } else if (str.equals("电源")) {
            partsAdapter = new PartsAdapter(power, str, this, position);
        } else if (str.equals("硬盘")) {
            partsAdapter = new PartsAdapter(harddisk, str, this, position);
        }else if (str.equals("散热")) {
            partsAdapter = new PartsAdapter(radiator, str, this, position);
        }else if (str.equals("机箱")) {
            partsAdapter = new PartsAdapter(chassis, str, this, position);
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
        //CPU数据注入
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

        //主板数据注入
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

        //显卡数据注入
        PartsTestData partsTestData3 = new PartsTestData();
        partsTestData3.setPartImage(R.drawable.nvidia_4060);
        partsTestData3.setPartName("华硕RTX4090 24G猛禽火神");
        partsTestData3.setPartParameter("一款性能出色的显卡");
        partsTestData3.setPartPrice(2199);
        PartsTestData partsTestData4 = new PartsTestData();
        partsTestData4.setPartImage(R.drawable.nvidia_4060);
        partsTestData4.setPartName("瑷珈4060ti");
        partsTestData4.setPartParameter("二次元甜品卡吗?");
        partsTestData4.setPartPrice(2699);
        PartsTestData partsTestData5 = new PartsTestData();
        partsTestData5.setPartImage(R.drawable.nvidia_4060);
        partsTestData5.setPartName("华硕ROG RTX 4060猛禽显卡");
        partsTestData5.setPartParameter("一款性能出色的显卡");
        partsTestData5.setPartPrice(2499);
        PartsTestData partsTestData6 = new PartsTestData();
        partsTestData6.setPartImage(R.drawable.nvidia_4060);
        partsTestData6.setPartName("铭瑄电竞终结者");
        partsTestData6.setPartParameter("一款性能出色的显卡");
        partsTestData6.setPartPrice(2399);
        graphics.add(partsTestData3);
        graphics.add(partsTestData4);
        graphics.add(partsTestData5);
        graphics.add(partsTestData6);

        //内存数据注入
        PartsTestData memorystick =new PartsTestData(R.drawable.nvidia_4060,"七彩虹存储"," 16GB DDR4 3200 台式机内存 普条系列 XMP",209);
        PartsTestData memorystick2 =new PartsTestData(R.drawable.nvidia_4060,"金士顿骇客神条 ","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        memorysticks.add(memorystick);
        memorysticks.add(memorystick2);

        //电源数据注入
        PartsTestData power1 =new PartsTestData(R.drawable.nvidia_4060,"先马破坏神450升级版"," 额定功率300W/支持6P+2P显卡供电",109);
        PartsTestData power2 =new PartsTestData(R.drawable.nvidia_4060,"爱国者额定500W黑暗骑士 ","650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)",149);
        power.add(power1);
        power.add(power2);
        //硬盘数据注入
        PartsTestData harddisk1 =new PartsTestData(R.drawable.nvidia_4060,"致态长江存储","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ",529);
        PartsTestData harddisk2 =new PartsTestData(R.drawable.nvidia_4060,"西部数据（WD）1TB SSD固态硬盘"," M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘",569);
        harddisk.add(harddisk1);
        harddisk.add(harddisk2);
        //散热器数据注入
        PartsTestData radiator1 =new PartsTestData(R.drawable.nvidia_4060,"Thermalright AX120 R SE CPU风冷散热器","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅脂 ",219);
        PartsTestData radiator2 =new PartsTestData(R.drawable.nvidia_4060,"酷冷至尊(CoolerMaster)暴雪T620S "," CPU风冷散热器 支持多平台/双塔/6热管/镀镍铜底/ARGB灯效/TDP260W",199);
        radiator.add(radiator1);
        radiator.add(radiator1);
        //机箱数据注入
        PartsTestData chassis1 =new PartsTestData(R.drawable.nvidia_4060,"长城阿基米德9 PRO白色电脑机箱","360水冷位/玻璃翻门/0.8mm厚侧板/5硬盘位/10风扇位/4090显卡 ",239);
        PartsTestData chassis2 =new PartsTestData(R.drawable.nvidia_4060,"半岛铁盒白泽360 白色海景房电脑机箱台式机","支持M-ATX主板/360水冷位/9风扇位/U3接口",159);
        chassis.add(chassis1);
        chassis.add(chassis2);
    }

}