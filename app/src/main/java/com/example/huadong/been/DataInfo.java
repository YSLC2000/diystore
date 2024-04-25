package com.example.huadong.been;

import android.content.Context;

import com.example.huadong.R;
import com.example.huadong.untils.OrderDataBase;

public class DataInfo {
    /**
     *SQLite数据库数据注入
     */
        public void dataInfo(Context context){
        long timestamp = System.currentTimeMillis();
        int time =(int)timestamp;
        OrderDataBase orderDataBase=new OrderDataBase(context, "order.db", null, 1);
        //显卡数据注入
        orderDataBase.infoParts("瑷珈4060ti",time, R.drawable.aijia4060ti,"显卡","瑷珈4060 Ti显卡融合二次元风格，外观独特。它采用AD106核心，配备强大流处理器与核心，显存带宽高。散热方案先进，风扇智能启停，兼具效能与静音。供电稳定，耐用性佳。总体表现出色，值得考虑。","2023/4",2699);
        orderDataBase.infoParts("华硕RTX4090 24G猛禽火神",time,R.drawable.rtx_4090,"显卡","华硕RTX4090 24G猛禽火神公版涡轮台式机电竞AI渲染游戏独立游戏显卡 ROG-STRIX-RTX4090-O24G白猛禽","2023/7",2199);
        orderDataBase.infoParts("华硕ROG RTX 4060猛禽显卡",time,R.drawable.nvidia_4060,"显卡","华硕（ASUS)ROG猛禽/TUF RTX4060/4060TI 台式机组装电脑发烧游戏全新独立显卡 ATS-4060-O8G-V2","2023/7",2399);
        orderDataBase.infoParts("微星（MSI）魔龙 GeForce RTX 4070 SUPER",time,R.drawable.rtx4070,"显卡","微星（MSI）魔龙 GeForce RTX 4070 SUPER 12G GAMING X SLIM 电竞游戏AI设计智能学习电脑独立显卡。","2023/7",2499);
        orderDataBase.infoParts("华硕6750gre 12G",time,R.drawable.amd_6750gre,"显卡","华硕（ASUS）DUAL RX6750GRE 12G V2 GAMING AMD RADEON RX 6750 GRE 游戏显卡","2023/7",2399);
        //内存数据注入
        orderDataBase.infoParts("七彩虹存储",time, R.drawable.colorful,"内存"," 16GB DDR4 3200 台式机内存 普条系列 XMP","2023/4",209);
        orderDataBase.infoParts("金士顿骇客神条",time, R.drawable.kingston,"内存"," 32GB(16G×2)套装 DDR5 6000 台式机内存条","2023/4",999);
        //电源数据注入
        orderDataBase.infoParts("先马破坏神450升级版",time, R.drawable.xianqv,"电源","额定功率300W/支持6P+2P显卡供电","2023/4",109);
        orderDataBase.infoParts("爱国者额定500W黑暗骑士",time, R.drawable.aigo,"电源"," 650DK 台式机电脑主机电源（主动式PFC/宽幅节能温控/长线材/支持背线)","2023/4",149);
        //硬盘数据注入
        orderDataBase.infoParts("致态长江存储",time, R.drawable.zhitai,"硬盘","1TB SSD固态硬盘 NVMe M.2接口 Ti600系列 ","2023/4",529);
        orderDataBase.infoParts("西部数据（WD）1TB SSD固态硬盘",time, R.drawable.xishu,"硬盘","M.2（NVMe协议）SN580 PCIe4.0 AI电脑配件 笔记本电脑台式机SN570升级储存硬盘","2023/4",569);
        //机箱数据注入
        orderDataBase.infoParts("长城阿基米德9 PRO白色电脑机箱",time, R.drawable.changcheng,"机箱","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅脂","2023/4",239);
        orderDataBase.infoParts("半岛铁盒白泽360 白色海景房电脑机箱台式机",time, R.drawable.bdth,"机箱","支持M-ATX主板/360水冷位/9风扇位/U3接口","2023/4",159);
        //散热器数据注入
        orderDataBase.infoParts("Thermalright AX120 R SE CPU风冷散热器",time, R.drawable.thermalright,"散热","AGHP逆重力热管支持LGA1700/AM5 4热管S-FDB12CM风扇附带硅","2023/4",219);
        orderDataBase.infoParts("酷冷至尊(CoolerMaster)暴雪T620S",time, R.drawable.klzz,"散热","CPU风冷散热器 支持多平台/双塔/6热管/镀镍铜底/ARGB灯效/TDP260W","2023/4",159);
        //主板数据注入
        orderDataBase.infoParts("b760m",time, R.drawable.b760m,"主板","酷睿十二代i5板板","2023/4",1300);
        orderDataBase.infoParts("z790",time, R.drawable.z790,"主板","酷睿十二代i7，i9板板","2023/4",1800);
        //CPU数据注入
        orderDataBase.infoParts("i9 14900k",time, R.drawable.i9_14900k,"CPU","高性能生产力cpu","2023/4",3999);
        orderDataBase.infoParts("i5 12400f",time, R.drawable.i512400f,"CPU","家用cpu","2023/4",1099);
        orderDataBase.infoParts("i7 13700k",time, R.drawable.i7_13700k,"CPU","我是高级生产力","2023/4",2999);
        orderDataBase.infoWebAdd("老黄刀法精准，这牙膏我还能再挤十年","https://zhuanlan.zhihu.com/p/630784566");
        orderDataBase.infoWebAdd("红色'农民崛起'，AMD yes！战未来","https://zhuanlan.zhihu.com/p/688876086");
        orderDataBase.infoWebAdd("4060居然不敌3060ti？到底如何让我们揭晓","https://www.zhihu.com/question/580295253/answer/2863045571");
        orderDataBase.infoWebAdd("6750gre究极对决4060，谁强孰弱？","https://ms.mbd.baidu.com/r/1i1wbpkbJUQ?f=cp&u=f415030d9d391153&urlext=%7B%22cuid%22%3A%22_uHYugucS80IOvizgaS9ulPjvu_6PStQ_avlijiOBfKo0qqSB%22%7D");
        orderDataBase.infoWebAdd("4090究极生产力","https://www.zhihu.com/question/500334548/answer/2712747100#!");
        }
}
