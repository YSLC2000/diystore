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
import com.example.huadong.been.CommentDetailBean;
import com.example.huadong.been.CommentInfo;
import com.example.huadong.been.DisplayListTestData;
import com.example.huadong.been.DisplayTestData;
import com.example.huadong.been.OrderData;
import com.example.huadong.been.OrderTestData;
import com.example.huadong.been.PartsTestData;
import com.example.huadong.been.ReplyDetailBean;
import com.example.huadong.been.ReplyInfo;
import com.example.huadong.been.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SplittableRandom;

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
                "memorySticks  varchar(32)," +
                "power varchar(32)," +
                "hardDisk varchar(32)," +
                "radiator varchar(32)," +
                "chassis varchar(32)," +
                "price int," +
                "time varchar(32)" +
                ")");
        db.execSQL("create table user_table(user_id integer primary key autoincrement," + "user_name text," +
                "password text" +
                ")");
        db.execSQL("create table share_table(user_name text,share_id varchar(32),share_name varchar(32),order_name varchar(32),user_img varchar(32),share_price int," +
                "share_num int" +
                ")");
        db.execSQL("create table part_table(part_name text,part_id int,part_img varchar(32),part_type varchar(32),part_parameter varchar(32),part_time varchar(32)," +
                "part_price int" +
                ")");
        /**
         * user_name分享者用户名
         * share_name分享订单的名字
         * comment_name评论者名字
         * comment_content评论者内容
         */
        db.execSQL("create table comment_table(comment_id int,user_name varchar(32),share_name varchar(32),part_img int,share_time varchar(32),comment_time varchar(32)," +
                "comment_name varchar(32)," +
                "comment_content varchar(32)" +
                ")");
        /**
         * comment_name是评论者名字
         * comment_content评论者内容
         * reply_name是回复者的名字
         * reply_content是回复者内容
         */
        db.execSQL("create table reply_table(reply_id int,comment_name varchar(32),comment_content varchar(32),reply_name varchar(32),reply_content varchar(32))");
        /**
         *
         * recommend_table
         * recommend
         * webAdd
         *    values.put("recommend", recommend);
         *         values.put("webAdd", webAdd);
         *         String nullData = "values(null,?,?)";
         *         int insert = (int) db.insert("recommend_table", nullData, values);
         */
         db.execSQL("create table recommend_table(recommend varchar(32),webAdd varchar(32))");
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
     * 加入分享表
     */
    public int addShare(String user_name, String share_id, String share_name, String order_name, String user_img, String share_price, int share_num) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_name", user_name);
        values.put("share_id", share_id);
        values.put("share_name", share_name);
        values.put("order_name", order_name);
        values.put("user_img", user_img);
        values.put("share_price", share_price);
        values.put("share_num", share_num);
        String nullData = "values(null,?,?,?,?,?,?,?)";
        int insert = (int) db.insert("share_table", nullData, values);
//        db.close();
        return insert;
    }

    /**
     * 加入订单表
     */
    public int addOrders(String user_name, String id, String name, String cpu, String mainBoard, String graphics, String memorySticks, String power, String hardDisk, String radiator, String chassis, int price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        long currentTimeMillis = System.currentTimeMillis(); // 获取当前时间的毫秒数
        Date time = new Date(currentTimeMillis); // 将毫秒数转换为Date对象
        values.put("user_name", user_name);
        values.put("order_id", id);
        values.put("order_name", name);
        values.put("cpu", cpu);
        values.put("mainBoard", mainBoard);
        values.put("graphics", graphics);
        values.put("memorySticks", memorySticks);
        values.put("power", power);
        values.put("hardDisk", hardDisk);
        values.put("radiator", radiator);
        values.put("chassis", chassis);
        values.put("price", price);
        values.put("time", time.toString());
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
        String sql = "select user_name,order_name,price,time from order_table where user_name=?";
        String[] selectionArgs = {userName};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            String order_name = cursor.getString(cursor.getColumnIndex("order_name"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            int price = cursor.getInt(cursor.getColumnIndex("price"));
            list.add(new OrderData(order_name, price, time));
        }
        cursor.close();
//        db.close();
        return list;
    }

    /**
     * 分享展示
     */
    @SuppressLint("Range")
    public List<String> display_order() {
        List<String> list = new ArrayList<>();
        return list;
    }

    /**
     * 删除订单
     */
    @SuppressLint("Range")
    public int delete_order(String order_name) {
        SQLiteDatabase db = getReadableDatabase();
        int delete = db.delete("order_table", "order_name=?", new String[]{order_name});
//        db.close();
        return delete;
    }

    /**
     * 订单分享展示加载
     */
    @SuppressLint("Range")
    public List<DisplayTestData> share_display() {
        SQLiteDatabase db = getReadableDatabase();
        List<DisplayTestData> list = new ArrayList<>();
        String sql = "select order_name,user_name,share_name,user_img,share_price,share_num from share_table";
        Cursor cursor = db.rawQuery(sql, null);
        List<DisplayListTestData> img_list = new ArrayList<>();
        DisplayListTestData displayListTestData = new DisplayListTestData();
        DisplayListTestData displayListTestData1 = new DisplayListTestData();
        displayListTestData.setImg(R.drawable.i9_14900k);
        displayListTestData1.setImg(R.drawable.nvidia_4060);
        img_list.add(displayListTestData);
        img_list.add(displayListTestData1);
        while (cursor.moveToNext()) {
            String share_name = cursor.getString(cursor.getColumnIndex("share_name"));
            String user_name = cursor.getString(cursor.getColumnIndex("user_name"));
            int user_img = cursor.getInt(cursor.getColumnIndex("user_img"));
            String share_price = cursor.getString(cursor.getColumnIndex("share_price"));
            int share_num = cursor.getInt(cursor.getColumnIndex("share_num"));
            list.add(new DisplayTestData(R.drawable.display_user_img_gwen, share_name, user_name, img_list, share_price, share_num));
        }
        return list;
    }

    /**
     * 点赞按钮自增功能
     */
    @SuppressLint("Range")
    public void thumbsUp() {
        SQLiteDatabase db = getWritableDatabase();
    }

    /**
     * 配件数据注入
     * db.execSQL("create table part_table(part_name text,part_id int,part_img varchar(32),part_type varchar(32),part_parameter varchar(32),part_time varchar(32),part_price int)");
     */
    public int infoParts(String part_name, int part_id, int part_img, String part_type, String part_parameter, String part_time, int part_price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("part_name", part_name);
        values.put("part_id", part_id);
        values.put("part_img", part_img);
        values.put("part_type", part_type);
        values.put("part_parameter", part_parameter);
        values.put("part_time", part_time);
        values.put("part_price", part_price);
        String nullData = "values(null,?,?,?,?,?,?,?)";
        int insert = (int) db.insert("part_table", nullData, values);
//        db.close();
        return insert;
    }

    /**
     * 通过配件名称查找其他参数
     */
    @SuppressLint("Range")
    public PartsTestData partsArgument(String part_name) {
        SQLiteDatabase db = getReadableDatabase();
        PartsTestData partsTestData = null;
        String sql = "select part_name,part_type,part_parameter,part_time,part_price  from part_table where part_name=?";
        String[] str = {part_name};
        Cursor cursor = db.rawQuery(sql, str);
        if (cursor.moveToNext()) {
            String partName = cursor.getString(cursor.getColumnIndex("part_name"));
            String partType = cursor.getString(cursor.getColumnIndex("part_type"));
            String partParameter = cursor.getString(cursor.getColumnIndex("part_parameter"));
            String partTime = cursor.getString(cursor.getColumnIndex("part_time"));
            int partPrice = cursor.getInt(cursor.getColumnIndex("part_price"));
            partsTestData = new PartsTestData(partName, partParameter, partType, partPrice, partTime);
        }
        cursor.close();
//        db.close();
        return partsTestData;
    }

    /**
     * 通过订单名称将其其中配件名称装入列表
     */
    @SuppressLint("Range")
    public List<String> selectPart(String order_name) {
        List<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
//         OrderTestData orderTestData =null;
        String sql = "select cpu,mainBoard,graphics,memorySticks,power,hardDisk,radiator,chassis from order_table where order_name=?";
        String[] str = {order_name};
        Cursor cursor = db.rawQuery(sql, str);
        if (cursor.moveToNext()) {
            String cpu = cursor.getString(cursor.getColumnIndex("cpu"));
            String mainBoard = cursor.getString(cursor.getColumnIndex("mainBoard"));
            String graphics = cursor.getString(cursor.getColumnIndex("graphics"));
            String memorySticks = cursor.getString(cursor.getColumnIndex("memorySticks"));
            String power = cursor.getString(cursor.getColumnIndex("power"));
            String hardDisk = cursor.getString(cursor.getColumnIndex("hardDisk"));
            String radiator = cursor.getString(cursor.getColumnIndex("radiator"));
            String chassis = cursor.getString(cursor.getColumnIndex("chassis"));
//             orderTestData =new OrderTestData(cpu,mainBoard,graphics,memorySticks,power,hardDisk,radiator,chassis);
            list.add(cpu);
            list.add(mainBoard);
            list.add(graphics);
            list.add(memorySticks);
            list.add(power);
            list.add(hardDisk);
            list.add(radiator);
            list.add(chassis);
        }
        return list;
    }

    /**
     * 点击发表评论后将内容加入评论表
     */
    @SuppressLint("Range")
    public int commentsInfo(int comment_id, String user_name, String share_name, int part_img, String share_time, String comment_time, String comment_name, String comment_content) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("comment_id", comment_id);
        values.put("user_name", user_name);
        values.put("share_name", share_name);
        values.put("part_img", part_img);
        values.put("share_time", share_time);
        values.put("comment_time", comment_time);
        values.put("comment_name", comment_name);
        values.put("comment_content", comment_content);
        String nullData = "values(null,?,?,?,?,?,?,?,?)";
        int insert = (int) db.insert("comment_table", nullData, values);
//        db.close();
        return insert;
    }

//    /**
//     * 从评论表中获取数据
//     */
//    @SuppressLint("Range")
//    public List<CommentInfo> getCommentInfo(String user_name, String share_name) {
//        List<CommentInfo> list = new ArrayList<>();
//        SQLiteDatabase db = getReadableDatabase();
//        CommentInfo commentInfo = null;
//        String sql = "select comment_id, user_name, share_name, part_img, share_time, comment_time, comment_name, comment_content from comment_table where user_name=? and share_name=?";
//        String[] str = {user_name, share_name};
//        Cursor cursor = db.rawQuery(sql, str);
//        while (cursor.moveToNext()) {
//            int commentID = cursor.getInt(cursor.getColumnIndex("comment_id"));
//            String userName = cursor.getString(cursor.getColumnIndex("user_name"));
//            String shareName = cursor.getString(cursor.getColumnIndex("share_name"));
//            int partImg = cursor.getInt(cursor.getColumnIndex("part_img"));
//            String shareTime = cursor.getString(cursor.getColumnIndex("share_time"));
//            String commentTime = cursor.getString(cursor.getColumnIndex("comment_time"));
//            String commentName = UserInfo.sUserInfo.getUsername();
//            String commentContent = cursor.getString(cursor.getColumnIndex("comment_content"));
//            commentInfo = new CommentInfo(commentID, userName, shareName, partImg, shareTime, commentTime, commentName, commentContent);
//            list.add(commentInfo);
//        }
//        return list;
//    }

    /**
     * 点击回复后将内容插入到回复表中
     * comment_name varchar(32),reply_name varchar(32),replay_content varchar(32)
     */
    @SuppressLint("Range")
    public int replyInfo(int reply_id, String comment_name, String comment_content, String reply_name, String reply_content) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("reply_id", reply_id);
        values.put("comment_name", comment_name);
        values.put("comment_content", comment_content);
        values.put("reply_name", reply_name);
        values.put("reply_content", reply_content);
        String nullData = "values(null,?,?,?,?,?)";
        int insert = (int) db.insert("reply_table", nullData, values);
//        db.close();
        return insert;
    }


    /**
     * 通过user_name和share_name获取CommentDetailBean列表加入到CommentExpandAdapt中
     * user_name分享者用户名
     * share_name分享订单的名字
     * comment_name评论者名字
     * comment_content评论者内容
     */
    @SuppressLint("Range")
    public List<CommentDetailBean> getCommentDetailBean(String user_name, String share_name) {
        List<CommentDetailBean> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        CommentDetailBean commentDetailBean = null;
        String sql = "select comment_id, user_name, share_name, part_img, share_time, comment_time, comment_name, comment_content from comment_table where user_name=? and share_name=?";
        String[] str = {user_name, share_name};
        Cursor cursor = db.rawQuery(sql, str);
        while (cursor.moveToNext()) {
            int commentID = cursor.getInt(cursor.getColumnIndex("comment_id"));
            String userName = cursor.getString(cursor.getColumnIndex("user_name"));
            String shareName = cursor.getString(cursor.getColumnIndex("share_name"));
            int partImg = cursor.getInt(cursor.getColumnIndex("part_img"));
            String shareTime = cursor.getString(cursor.getColumnIndex("share_time"));
            String commentName = cursor.getString(cursor.getColumnIndex("comment_name"));
            String commentContent = cursor.getString(cursor.getColumnIndex("comment_content"));
            List<ReplyDetailBean> replyDetailBeans = getReplyDetailBeans(commentName, commentContent);
            commentDetailBean = new CommentDetailBean(userName, shareName, commentContent, commentName, replyDetailBeans);
            list.add(commentDetailBean);
        }
        return list;
    }

    /**
     * 从回复表中获取对应评论的回复数据将这些数据用集合存储
     */
    @SuppressLint("Range")
    public List<ReplyDetailBean> getReplyDetailBeans(String comment_name, String comment_content) {
        List<ReplyDetailBean> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        ReplyDetailBean replyDetailBean = null;
        String sql = "select reply_id ,comment_name ,comment_content,reply_name ,reply_content from reply_table where comment_name=? and comment_content=?";
        String[] str = {comment_name, comment_content};
        Cursor cursor = db.rawQuery(sql, str);
        while (cursor.moveToNext()) {
            String commentName = cursor.getString(cursor.getColumnIndex("comment_name"));
            String commentContent = cursor.getString(cursor.getColumnIndex("comment_content"));
            String replyName = cursor.getString(cursor.getColumnIndex("reply_name"));
            String replyContent = cursor.getString(cursor.getColumnIndex("reply_content"));
            replyDetailBean = new ReplyDetailBean(replyName, replyContent, commentName, commentContent);
            list.add(replyDetailBean);
        }
        return list;
    }

    /**
     * 搜索功能
     */
    @SuppressLint("Range")
    public List<DisplayTestData> displaySearch(String share_name) {
        SQLiteDatabase db = getReadableDatabase();
        List<DisplayTestData> list = new ArrayList<>();
        String selection = "share_name LIKE ?";
        String[] selectionArgs = new String[]{"%" + share_name + "%"};
//        String sql = "select order_name,user_name,share_name,user_img,share_price,share_num from share_table where share_name=?";
//        String[] shareName = new String[]{"%" + share_name + "%"};
        Cursor cursor = db.query("share_table", null, selection, selectionArgs, null, null, null);
        List<DisplayListTestData> img_list = new ArrayList<>();
        DisplayListTestData displayListTestData = new DisplayListTestData();
        DisplayListTestData displayListTestData1 = new DisplayListTestData();
        displayListTestData.setImg(R.drawable.i9_14900k);
        displayListTestData1.setImg(R.drawable.nvidia_4060);
        img_list.add(displayListTestData);
        img_list.add(displayListTestData1);
        while (cursor.moveToNext()) {
            String shareName1 = cursor.getString(cursor.getColumnIndex("share_name"));
            String user_name = cursor.getString(cursor.getColumnIndex("user_name"));
            int user_img = cursor.getInt(cursor.getColumnIndex("user_img"));
            String share_price = cursor.getString(cursor.getColumnIndex("share_price"));
            int share_num = cursor.getInt(cursor.getColumnIndex("share_num"));
            list.add(new DisplayTestData(R.drawable.display_user_img_gwen, shareName1, user_name, img_list, share_price, share_num));
        }
        return list;
    }
    /**
     * 通过推荐名查找webView网址
     */
    @SuppressLint("Range")
    public String getWebView(String recommend){
        String web = null;
        SQLiteDatabase db =getReadableDatabase();
        String sql ="select recommend,webAdd from recommend_table where recommend=?";
        String[] condition ={recommend};
        Cursor cursor=db.rawQuery(sql,condition);
        if(cursor.moveToNext()){
             web =cursor.getString(cursor.getColumnIndex("webAdd"));
        }
        return web;
    }
    /**
     * 插入推荐名webView网址
     */
    public void infoWebAdd(String recommend,String webAdd){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("recommend", recommend);
        values.put("webAdd", webAdd);
        String nullData = "values(null,?,?)";
        db.insert("recommend_table", nullData, values);
//        db.close();
    }
}
