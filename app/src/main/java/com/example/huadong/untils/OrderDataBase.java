package com.example.huadong.untils;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.huadong.R;
import com.example.huadong.been.DisplayListTestData;
import com.example.huadong.been.DisplayTestData;
import com.example.huadong.been.OrderData;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.been.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDataBase extends SQLiteOpenHelper {
    public static OrderDataBase instance;


    public OrderDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static OrderDataBase getInstance(Context context) {
        if (null == instance) {
            instance = new OrderDataBase(context, "order.db", null, 1);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建一个table表
        db.execSQL("create table order_table(user_name text,order_id varchar(32),order_name varchar(32),cpu varchar(32),mainBoard varchar(32),graphics varchar(32)," +
                "memorySticks  varchar(32),"+
                "power varchar(32),"+
                "hardDisk varchar(32),"+
                "radiator varchar(32),"+
                "chassis varchar(32),"+
                "price int,"+
                "time varchar(32)"+
                ")");
        db.execSQL("create table user_table(user_id integer primary key autoincrement," + "user_name text," +
                "password text" +
                ")");
        db.execSQL("create table share_table(user_name text,share_id varchar(32),share_name varchar(32),order_name varchar(32),user_img varchar(32),share_price int," +
                "share_num int"+
                ")");
        db.execSQL("create table part_table(part_name text,part_id int,part_img varchar(32),part_type varchar(32),part_parameter varchar(32),part_time varchar(32),"+
                "part_price int"+
                ")");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public int addOrder(String user_name,String id, String name, String data) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("user_name",user_name);
//        values.put("order_id", id);
//        values.put("order_name", name);
//        values.put("order_text", data);
//        String nullData = "values(null,?,?,?,?)";
//        int insert = (int) db.insert("order_table", nullData, values);
////        db.close();
//        return insert;
//    }

    /**
     *加入分享表
     */
    public int addShare(String user_name,String share_id, String share_name,String order_name, String user_img,String share_price,int share_num) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_name",user_name);
        values.put("share_id", share_id);
        values.put("share_name", share_name);
        values.put("order_name",order_name);
        values.put("user_img", user_img);
        values.put("share_price",share_price);
        values.put("share_num",share_num);
        String nullData = "values(null,?,?,?,?,?,?,?)";
        int insert = (int) db.insert("share_table", nullData, values);
//        db.close();
        return insert;
    }

    /**
     * 加入订单表
     */
    public int addOrders(String user_name,String id, String name,String cpu, String mainBoard,String graphics,String memorySticks,String power,String hardDisk,String radiator,String chassis,int price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        long currentTimeMillis = System.currentTimeMillis(); // 获取当前时间的毫秒数
        Date time = new Date(currentTimeMillis); // 将毫秒数转换为Date对象
        values.put("user_name",user_name);
        values.put("order_id", id);
        values.put("order_name", name);
        values.put("cpu",cpu);
        values.put("mainBoard", mainBoard);
        values.put("graphics",graphics);
        values.put("memorySticks",memorySticks);
        values.put("power",power);
        values.put("hardDisk",hardDisk);
        values.put("radiator",radiator);
        values.put("chassis",chassis);
        values.put("price",price);
        values.put("time",time.toString());
        String nullData = "values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int insert = (int) db.insert("order_table", nullData, values);
//        db.close();
        return insert;
    }




    //登录
    @SuppressLint("Range")
    public UserInfo login(String username) {
        SQLiteDatabase db = getReadableDatabase();
        UserInfo userInfo = null;
        String sql = "select user_id,user_name,password  from user_table where user_name=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("user_name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            userInfo = new UserInfo(user_id, name, password);
        }
        cursor.close();
//        db.close();
        return userInfo;
    }

    //注册
    public int register(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_name", username);
        values.put("password", password);
        String nullColumnHack = "values(null,?,?)";
        int insert = (int) db.insert("user_table", nullColumnHack, values);
//        db.close();
        return insert;
    }

//    public List<String> order_display() throws JSONException {
//
//        List<String> list = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from order_table", null);
//        if (cursor.moveToFirst()) {
//            int rowCount = cursor.getCount();
//            for (int i = 0; i < rowCount; i++) {
//                cursor.moveToPosition(i);
//                int columnIndex = cursor.getColumnIndex("order_text");
//                String data = cursor.getString(columnIndex);
//                JSONObject jsonObject = new JSONObject(data);
//                list.add(data);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (String item : list) {
//            sb.append(item).append("\n");
//        }
//        String result = sb.toString();
////        Log.d("order_table表遍历数据",result);
//        cursor.close();
//
//        return list;
//    }

    /**
     * 个人中心中订单加载
     */
    @SuppressLint("Range")
    public List<OrderData> queryCarList(String userName) {
        SQLiteDatabase db = getReadableDatabase();
        List<OrderData> list = new ArrayList<>();
        String sql = "select user_name,order_name,time from order_table where user_name=?";
        String[] selectionArgs = {userName};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            String order_name = cursor.getString(cursor.getColumnIndex("order_name"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            list.add(new OrderData(order_name,1999,time));
        }
        cursor.close();
//        db.close();
        return list;
    }
    /**
     * 分享展示
     */
    @SuppressLint("Range")
    public List<String> display_order(){
        List<String> list =new ArrayList<>();
        return list;
    }
    /**
     * 删除订单
     */
    @SuppressLint("Range")
    public int delete_order(String order_name){
        SQLiteDatabase db =getReadableDatabase();
        int delete =db.delete("order_table" ,"order_name=?",new String[]{order_name});
//        db.close();
        return delete;
    }
    /**
     * 订单分享展示加载
     */
    @SuppressLint("Range")
    public List<DisplayTestData> share_display(){
        SQLiteDatabase db =getReadableDatabase();
        List<DisplayTestData> list =new ArrayList<>();
        String sql ="select order_name,user_name,share_name,user_img,share_price,share_num from share_table";
        Cursor cursor = db.rawQuery(sql,null);
        List<DisplayListTestData> img_list =new ArrayList<>();
        DisplayListTestData displayListTestData=new DisplayListTestData();
        displayListTestData.setImg(R.drawable.i9_14900k);
        displayListTestData.setImg(R.drawable.nvidia_4060);
        img_list.add(displayListTestData);
        while(cursor.moveToNext()){
            String share_name = cursor.getString(cursor.getColumnIndex("share_name"));
            String user_name =cursor.getString(cursor.getColumnIndex("user_name"));
            int user_img =cursor.getInt(cursor.getColumnIndex("user_img"));
            String share_price= cursor.getString(cursor.getColumnIndex("share_price"));
            int share_num =cursor.getInt(cursor.getColumnIndex("share_num"));
            list.add(new DisplayTestData(R.drawable.display_user_img_gwen,share_name,user_name, img_list,share_price,share_num));
        }
        return list;
    }
    /**
     * 点赞按钮自增功能
     */
    @SuppressLint("Range")
    public void thumbsUp(){
        SQLiteDatabase db=getWritableDatabase();
    }
    /**
     * 配件数据注入
     * db.execSQL("create table part_table(part_name text,part_id int,part_img varchar(32),part_type varchar(32),part_parameter varchar(32),part_time varchar(32),part_price int)");
     */
    public int infoParts(String part_name,int part_id,int part_img,String part_type,String part_parameter,String part_time,int part_price){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("part_name",part_name);
        values.put("part_id", part_id);
        values.put("part_img", part_img);
        values.put("part_type",part_type);
        values.put("part_parameter", part_parameter);
        values.put("part_time",part_time);
        values.put("part_price",part_price);
        String nullData = "values(null,?,?,?,?,?,?,?)";
        int insert = (int) db.insert("part_table", nullData, values);
//        db.close();
        return insert;
    }
    /**
     * 通过配件名称查找其他参数
     */
    @SuppressLint("Range")
    public PartsTestData partsArgument(String part_name){
        SQLiteDatabase db=getReadableDatabase();
        PartsTestData partsTestData =null;
        String sql = "select part_name,part_type,part_parameter,part_time,part_price  from part_table where part_name=?";
        String[] str ={part_name};
        Cursor cursor = db.rawQuery(sql,str);
        if(cursor.moveToNext()){
           String partName = cursor.getString(cursor.getColumnIndex("part_name"));
           String partType = cursor.getString(cursor.getColumnIndex("part_type"));
           String partParameter = cursor.getString(cursor.getColumnIndex("part_parameter"));
           String partTime =cursor.getString(cursor.getColumnIndex("part_time"));
           int partPrice =cursor.getInt(cursor.getColumnIndex("part_price"));
           partsTestData=new PartsTestData(partName,partParameter,partType,partPrice,partTime);
        }
        cursor.close();
//        db.close();
        return partsTestData;
    }
}
