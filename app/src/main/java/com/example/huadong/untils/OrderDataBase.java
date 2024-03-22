package com.example.huadong.untils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

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
        db.execSQL("create table order_table( order_name varchar(32), order_text varchar(32))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int addOrder(String name, String data) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("order_name", name);
        values.put("order_text", data);
//        String nullData = "values(,?,?)";
        int insert = (int) db.insert("order_table", null, values);
//        db.close();
        return insert;
    }

}
