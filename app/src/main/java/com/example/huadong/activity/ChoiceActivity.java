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
        cpu.setPartName("i5 12400f");
        cpu.setPartImage(R.drawable.i512400f);
        cpu.setPartParameter("游戏不用愁，2k上我我能行");
        cpu.setPartPrice(1099);
        PartsTestData cpu1 = new PartsTestData();
        cpu1.setPartName("i7 13700k");
        cpu1.setPartImage(R.drawable.i7_13700k);
        cpu1.setPartParameter("我是高级生产力");
        cpu1.setPartPrice(2999);
        PartsTestData cpu2 =new PartsTestData(R.drawable.i5_14400f,"英特尔 i5-14400F 酷睿14代","处理器 10核16线程 睿频至高可达4.7Ghz 20M三级缓存 台式机盒装CPU",1599);
        PartsTestData cpu3 =new PartsTestData(R.drawable.i3_14100f,"英特尔 i3-14100F","4核8线程 睿频至高可达4.7Ghz 12M三级缓存 台式机盒装CPU",999);
        PartsTestData cpu4 =new PartsTestData(R.drawable.i7_14700kf,"英特尔 i7-14700KF","酷睿14代 处理器 20核28线程 睿频至高可达5.6Ghz 33M三级缓存 台式机盒装CPU",2999);
        PartsTestData cpu5 =new PartsTestData(R.drawable.i5_13400f,"英特尔 i5-13400F","酷睿13代 处理器 10核16线程 睿频至高可达4.6Ghz 20M三级缓存 台式机CPU",1449);
        PartsTestData cpu6 =new PartsTestData(R.drawable.amd7,"AMD 锐龙7 7800X3D游戏处理器","8核16线程 104MB游戏缓存 加速频率至高5.0GHz 盒装CPU",2549);
        cpu_list.add(cpu6);
        cpu_list.add(partsTestData);
        cpu_list.add(cpu);
        cpu_list.add(cpu1);
        cpu_list.add(cpu2);
        cpu_list.add(cpu3);
        cpu_list.add(cpu4);
        cpu_list.add(cpu5);

        //主板数据注入
        PartsTestData partsTestData1 = new PartsTestData();
        partsTestData1.setPartImage(R.drawable.b760m);
        partsTestData1.setPartName("Asus/华硕ROG STRIX B760-G");
        partsTestData1.setPartParameter("GAMING WIFI/D4小吹雪台式机电脑主板，支持酷睿13、14代cpu");
        partsTestData1.setPartPrice(1159);
        PartsTestData partsTestData2 = new PartsTestData();
        partsTestData2.setPartImage(R.drawable.z790);
        partsTestData2.setPartName("技嘉 Z790M AORUS ELITE AX");
        partsTestData2.setPartParameter("ICE冰雕/小雕/魔鹰X/雪雕ATX白色主板，支持酷睿13、14代cpu");
        partsTestData2.setPartPrice(1189);
        //新数据
        PartsTestData zb = new PartsTestData(R.drawable.z690,"Asus/华硕ROG STRIX Z690-A","GAMING WIFI D4吹雪主板支持12代酷睿",1099);
        PartsTestData zb1 = new PartsTestData(R.drawable.b660,"Asus/华硕PRIME B660M-K","12代酷睿i5 12400f主板CPU套装 H610M-K",699);
        PartsTestData zb2 = new PartsTestData(R.drawable.b650m,"微星B650M 主板","GAMING B650M-PLUS WIFI 迫击炮主板 支持 CPU",3197);
        mianboard_list.add(zb);
        mianboard_list.add(zb1);
        mianboard_list.add(zb2);
        mianboard_list.add(partsTestData1);
        mianboard_list.add(partsTestData2);

        //显卡数据注入
        PartsTestData partsTestData3 = new PartsTestData();
        partsTestData3.setPartImage(R.drawable.rtx_4090);
        partsTestData3.setPartName("华硕RTX4090 24G猛禽火神");
        partsTestData3.setPartParameter("显卡魔王登场");
        partsTestData3.setPartPrice(2199);
        PartsTestData partsTestData4 = new PartsTestData();
        partsTestData4.setPartImage(R.drawable.aijia4060ti);
        partsTestData4.setPartName("瑷珈4060ti");
        partsTestData4.setPartParameter("二次元甜品卡吗?");
        partsTestData4.setPartPrice(2699);
        PartsTestData partsTestData5 = new PartsTestData();
        partsTestData5.setPartImage(R.drawable.nvidia_4060);
        partsTestData5.setPartName("华硕ROG RTX 4060猛禽显卡");
        partsTestData5.setPartParameter("2k入门级显卡");
        partsTestData5.setPartPrice(2499);
        PartsTestData partsTestData6 = new PartsTestData();
        partsTestData6.setPartImage(R.drawable.rtx4070);
        partsTestData6.setPartName("微星（MSI）魔龙 GeForce RTX 4070 SUPER");
        partsTestData6.setPartParameter("一款性能出色的显卡");
        partsTestData6.setPartPrice(2399);
        PartsTestData partsTestData7 = new PartsTestData(R.drawable.amd_6750gre,"华硕6750gre 12G","AMD跨时代产品",2399);
        graphics.add(partsTestData3);
        graphics.add(partsTestData4);
        graphics.add(partsTestData5);
        graphics.add(partsTestData6);
        graphics.add(partsTestData7);

        //内存数据注入
        PartsTestData memorystick =new PartsTestData(R.drawable.colorful,"七彩虹存储"," 16GB DDR4 3200 台式机内存 普条系列 XMP",209);
        PartsTestData memorystick2 =new PartsTestData(R.drawable.kingston,"金士顿骇客神条","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        PartsTestData memorystick3 =new PartsTestData(R.drawable.kingston,"金士顿骇客神条","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        PartsTestData memorystick4 =new PartsTestData(R.drawable.kingston,"金士顿骇客神条","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        PartsTestData memorystick5 =new PartsTestData(R.drawable.kingston,"金士顿骇客神条","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        PartsTestData memorystick6 =new PartsTestData(R.drawable.kingston,"金士顿骇客神条","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        PartsTestData memorystick7 =new PartsTestData(R.drawable.kingston,"金士顿骇客神条","32GB(16G×2)套装 DDR5 6000 台式机内存条 ",999);
        memorysticks.add(memorystick);
        memorysticks.add(memorystick2);
        memorysticks.add(memorystick3);
        memorysticks.add(memorystick4);
        memorysticks.add(memorystick5);
        memorysticks.add(memorystick6);
        memorysticks.add(memorystick7);

        //电源数据注入
        PartsTestData power1 =new PartsTestData(R.drawable.xianqv,"先马破坏神450升级版"," 额定功率300W/支持6P+2P显卡供电",109);
        PartsTestData power2 =new PartsTestData(R.drawable.aigo,"爱国者额定500W黑暗骑士","650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)",149);
        PartsTestData power3 =new PartsTestData(R.drawable.xianqv,"先马破坏神450升级版"," 额定功率300W/支持6P+2P显卡供电",109);
        PartsTestData power4 =new PartsTestData(R.drawable.aigo,"爱国者额定500W黑暗骑士","650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)",149);
        PartsTestData power5 =new PartsTestData(R.drawable.xianqv,"先马破坏神450升级版"," 额定功率300W/支持6P+2P显卡供电",109);
        PartsTestData power6 =new PartsTestData(R.drawable.aigo,"爱国者额定500W黑暗骑士","650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)",149);
        PartsTestData power7 =new PartsTestData(R.drawable.xianqv,"先马破坏神450升级版"," 额定功率300W/支持6P+2P显卡供电",109);
        PartsTestData power8 =new PartsTestData(R.drawable.aigo,"爱国者额定500W黑暗骑士","650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)",149);
        PartsTestData power9 =new PartsTestData(R.drawable.xianqv,"先马破坏神450升级版"," 额定功率300W/支持6P+2P显卡供电",109);
        PartsTestData power10 =new PartsTestData(R.drawable.aigo,"爱国者额定500W黑暗骑士","650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)",149);
        power.add(power1);
        power.add(power2);
        power.add(power3);
        power.add(power4);
        power.add(power5);
        power.add(power6);
        power.add(power7);
        power.add(power8);
        power.add(power9);
        power.add(power10);

        //硬盘数据注入
        PartsTestData harddisk1 =new PartsTestData(R.drawable.zhitai,"致态长江存储","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ",529);
        PartsTestData harddisk2 =new PartsTestData(R.drawable.xishu,"西部数据（WD）1TB SSD固态硬盘"," M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘",569);
        PartsTestData harddisk3 =new PartsTestData(R.drawable.zhitai,"致态长江存储","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ",529);
        PartsTestData harddisk4 =new PartsTestData(R.drawable.xishu,"西部数据（WD）1TB SSD固态硬盘"," M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘",569);
        PartsTestData harddisk5 =new PartsTestData(R.drawable.zhitai,"致态长江存储","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ",529);
        PartsTestData harddisk6 =new PartsTestData(R.drawable.xishu,"西部数据（WD）1TB SSD固态硬盘"," M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘",569);
        PartsTestData harddisk7 =new PartsTestData(R.drawable.zhitai,"致态长江存储","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ",529);
        PartsTestData harddisk8 =new PartsTestData(R.drawable.xishu,"西部数据（WD）1TB SSD固态硬盘"," M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘",569);
        PartsTestData harddisk9 =new PartsTestData(R.drawable.zhitai,"致态长江存储","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ",529);
        PartsTestData harddisk10 =new PartsTestData(R.drawable.xishu,"西部数据（WD）1TB SSD固态硬盘"," M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘",569);
        harddisk.add(harddisk1);
        harddisk.add(harddisk2);
        harddisk.add(harddisk3);
        harddisk.add(harddisk4);
        harddisk.add(harddisk5);
        harddisk.add(harddisk6);
        harddisk.add(harddisk7);
        harddisk.add(harddisk8);
        harddisk.add(harddisk9);
        harddisk.add(harddisk10);
        //散热器数据注入
        PartsTestData radiator1 =new PartsTestData(R.drawable.thermalright,"Thermalright AX120 R SE CPU风冷散热器","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅脂 ",219);
        PartsTestData radiator2 =new PartsTestData(R.drawable.klzz,"酷冷至尊(CoolerMaster)暴雪T620S"," CPU风冷散热器 支持多平台/双塔/6热管/镀镍铜底/ARGB灯效/TDP260W",199);
        PartsTestData radiator3 =new PartsTestData(R.drawable.thermalright,"Thermalright AX120 R SE CPU风冷散热器","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅脂 ",219);
        PartsTestData radiator4 =new PartsTestData(R.drawable.klzz,"酷冷至尊(CoolerMaster)暴雪T620S"," CPU风冷散热器 支持多平台/双塔/6热管/镀镍铜底/ARGB灯效/TDP260W",199);
        PartsTestData radiator5 =new PartsTestData(R.drawable.thermalright,"Thermalright AX120 R SE CPU风冷散热器","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅脂 ",219);
        PartsTestData radiator6 =new PartsTestData(R.drawable.klzz,"酷冷至尊(CoolerMaster)暴雪T620S"," CPU风冷散热器 支持多平台/双塔/6热管/镀镍铜底/ARGB灯效/TDP260W",199);
        PartsTestData radiator7 =new PartsTestData(R.drawable.thermalright,"Thermalright AX120 R SE CPU风冷散热器","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅脂 ",219);
        PartsTestData radiator8 =new PartsTestData(R.drawable.klzz,"酷冷至尊(CoolerMaster)暴雪T620S"," CPU风冷散热器 支持多平台/双塔/6热管/镀镍铜底/ARGB灯效/TDP260W",199);
        radiator.add(radiator1);
        radiator.add(radiator2);
        radiator.add(radiator3);
        radiator.add(radiator4);
        radiator.add(radiator5);
        radiator.add(radiator6);
        radiator.add(radiator7);
        radiator.add(radiator8);
        //机箱数据注入
        PartsTestData chassis1 =new PartsTestData(R.drawable.changcheng,"长城阿基米德9 PRO白色电脑机箱","360水冷位/玻璃翻门/0.8mm厚侧板/5硬盘位/10风扇位/4090显卡 ",239);
        PartsTestData chassis2 =new PartsTestData(R.drawable.bdth,"半岛铁盒白泽360 白色海景房电脑机箱台式机","支持M-ATX主板/360水冷位/9风扇位/U3接口",159);
        PartsTestData chassis3 =new PartsTestData(R.drawable.changcheng,"长城阿基米德9 PRO白色电脑机箱","360水冷位/玻璃翻门/0.8mm厚侧板/5硬盘位/10风扇位/4090显卡 ",239);
        PartsTestData chassis4 =new PartsTestData(R.drawable.bdth,"半岛铁盒白泽360 白色海景房电脑机箱台式机","支持M-ATX主板/360水冷位/9风扇位/U3接口",159);
        PartsTestData chassis5 =new PartsTestData(R.drawable.bdth,"半岛铁盒白泽360 白色海景房电脑机箱台式机","支持M-ATX主板/360水冷位/9风扇位/U3接口",159);
        PartsTestData chassis6 =new PartsTestData(R.drawable.bdth,"半岛铁盒白泽360 白色海景房电脑机箱台式机","支持M-ATX主板/360水冷位/9风扇位/U3接口",159);
        chassis.add(chassis1);
        chassis.add(chassis2);
        chassis.add(chassis3);
        chassis.add(chassis4);
        chassis.add(chassis5);
        chassis.add(chassis6);

    }

}