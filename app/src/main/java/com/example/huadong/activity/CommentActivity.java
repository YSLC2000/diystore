package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.huadong.ExpandableListAdapter.CommentExpandAdapt;
import com.example.huadong.R;
import com.example.huadong.been.CommentBean;
import com.example.huadong.been.CommentDetailBean;
import com.example.huadong.been.CommentInfo;
import com.example.huadong.been.ReplyDetailBean;
import com.example.huadong.been.ReplyInfo;
import com.example.huadong.been.UserInfo;
import com.example.huadong.untils.OrderDataBase;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity{
    private CommentExpandAdapt commentExpandAdapt;
    private ExpandableListView expandableListView;
    private CommentBean commentBean;
    private List<CommentDetailBean> list =new ArrayList<>();
    private List<CommentInfo> commentInfo_data= new ArrayList<>();
    List<CommentDetailBean> commentDetailBeans;
    private BottomSheetDialog dialog;
    private TextView textView,content,share;
    private ImageView imageView;
    private Toolbar toolbar;
    private String user_name,share_name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        expandableListView =findViewById(R.id.comment_list);
        Intent intent=getIntent();
        user_name = intent.getStringExtra("username");
        share_name =intent.getStringExtra("ordername");
//        commentInfo_data = OrderDataBase.getInstance(CommentActivity.this).getCommentInfo(user_name,share_name);
//        commentDetailBeans =OrderDataBase.getInstance(CommentActivity.this).getComment( UserInfo.sUserInfo.getUsername(), share_name);//UserInfo.sUserInfo.getUsername()
//                OrderDataBase.getInstance(CommentActivity.this).getCommentDetailBean("1","TESt");
//        Log.d("commentDetailBeans",commentDetailBeans.toString());

//        for(int i=0;i<commentInfo_data.size();i++){
//            //获取comment的name
//            String name=commentInfo_data.get(i).getUser_name();
//            String content= commentInfo_data.get(i).getComment_content();
//            String time=commentInfo_data.get(i).getComment_time();
//            //获取reply的name
//            String commentName =commentInfo_data.get(i).getComment_name();
//            List<ReplyDetailBean> replyDetailBeans =new ArrayList<>();
//            List<ReplyInfo> reply=OrderDataBase.getInstance(CommentActivity.this).getReply(name,content);
//            for (int j = 0; j<reply.size(); j++){
//                String comment_name =reply.get(j).getComment_name();
//                String comment_content =reply.get(j).getReplay_content();
//                ReplyDetailBean replyDetailBean =new ReplyDetailBean(comment_name,comment_content);
//                replyDetailBeans.add(replyDetailBean);
//            }
//            CommentDetailBean commentBean =new CommentDetailBean(name,content,time,commentName,replyDetailBeans);
//            list.add(commentBean);
//        }
//        Log.d("list数据",list.toString());
        list=OrderDataBase.getInstance(CommentActivity.this).getCommentDetailBean(user_name,share_name);
        Log.d("OrderDataBase获取的数据",list.toString());
        initExpandableListView(list);
        textView=findViewById(R.id.textView9);
        textView.setText(user_name);
        toolbar=findViewById(R.id.comment_back);
        share=findViewById(R.id.detail_page_do_comment);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentDialog();

            }
        });
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imageView=findViewById(R.id.imageView4);
        content=findViewById(R.id.textView10);
        content.setText(share_name);
        imageView.setImageResource(R.drawable.display_user_img_gwen);

    }



    private void initExpandableListView( List<CommentDetailBean> commentList){
        expandableListView.setGroupIndicator(null);
        expandableListView.setDivider(null);
        Log.d("CommentActivity",commentList.toString());
        //默认展开所有回复
        commentExpandAdapt = new CommentExpandAdapt(this, commentList);
        expandableListView.setAdapter(commentExpandAdapt);
        for(int i = 0; i<commentList.size(); i++){
            expandableListView.expandGroup(i);
//
        }
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

//                if(isExpanded){
//                    expandableListView.collapseGroup(groupPosition);
//                }else {
//                    expandableListView.expandGroup(groupPosition, true);
//                }
                showReplyDialog(groupPosition);
                Toast.makeText(CommentActivity.this,"点击了其中一项",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(CommentActivity.this,"点击了回复",Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(CommentActivity.this,"展开第"+groupPosition+"个分组",Toast.LENGTH_SHORT).show();

            }
        });

    }
    //    private void intiData() {
    //        List<CommentDetailBean> list =new ArrayList<>();
    //        CommentDetailBean commentBean1 =new CommentDetailBean("小明","你还是","不久前");
    //        commentExpandAdapt.addTheCommentData(commentBean1);
    //        Toast.makeText(CommentActivity.this,"评论成功",Toast.LENGTH_SHORT).show();
    //    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId() == android.R.id.home){
            finish();
            return true;
            }
            return super.onOptionsItemSelected(item);
        }

    /**
     * func:弹出评论框
     */
    private void showCommentDialog(){
        dialog = new BottomSheetDialog(this);
        View commentView = LayoutInflater.from(this).inflate(R.layout.expand_comment_dialog,null);
         EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        dialog.setContentView(commentView);
        /**
         * 解决bsd显示不全的情况
         */
        View parent = (View) commentView.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        commentView.measure(0,0);
        behavior.setPeekHeight(commentView.getMeasuredHeight());

        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String commentContent = commentText.getText().toString().trim();
                if(!TextUtils.isEmpty(commentContent)){
                    //commentOnWork(commentContent);
                    OrderDataBase.getInstance(CommentActivity.this).commentsInfo((int)System.currentTimeMillis(),user_name,share_name,1,String.valueOf(System.currentTimeMillis()),String.valueOf(System.currentTimeMillis()),UserInfo.getsUserInfo().getUsername(),commentContent);
                    dialog.dismiss();
//                    List<ReplyInfo> list=OrderDataBase.getInstance(CommentActivity.this).getReply(String.valueOf(1),"TEST");
//                    List<ReplyDetailBean> list2 =new ArrayList<>();
//                    for(int i=0;i<list.size();i++){
//                        String str =list.get(i).getComment_name();
//                        String str1 =list.get(i).getReplay_content();
//                        ReplyDetailBean replyDetailBean =new ReplyDetailBean(str,str1);
//                        list2.add(replyDetailBean);
//                    }
                    CommentDetailBean detailBean = new CommentDetailBean(user_name, share_name,commentContent,UserInfo.getsUserInfo().getUsername(),OrderDataBase.getInstance(CommentActivity.this).getReplyDetailBeans(UserInfo.sUserInfo.getUsername(),commentContent));
                    commentExpandAdapt.addTheCommentData(detailBean);
                    Toast.makeText(CommentActivity.this,"评论成功",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(CommentActivity.this,"评论内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        commentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
                }else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }

    /**
     * func:弹出回复框
     */
    private void showReplyDialog(final int position){
        dialog = new BottomSheetDialog(this);
        View commentView = LayoutInflater.from(this).inflate(R.layout.expand_comment_dialog,null);
         EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        commentText.setHint("回复 " + list.get(position).getCommentName() + " 的评论:");
        dialog.setContentView(commentView);
        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replyContent = commentText.getText().toString().trim();
                OrderDataBase.getInstance(CommentActivity.this).replyInfo(1,list.get(position).getCommentName() ,list.get(position).getCreateDate(),UserInfo.getsUserInfo().getUsername(),replyContent);
                Toast.makeText(CommentActivity.this,replyContent,Toast.LENGTH_SHORT).show();
                if(!TextUtils.isEmpty(replyContent)){
                    dialog.dismiss();
                    ReplyDetailBean detailBean = new ReplyDetailBean(UserInfo.sUserInfo.getUsername(),replyContent,list.get(position).getCommentName(),list.get(position).getContent() );
                    commentExpandAdapt.addTheReplyData(detailBean, position);
                    expandableListView.expandGroup(position);
                    Toast.makeText(CommentActivity.this,replyContent,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CommentActivity.this,"回复内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        commentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
                }else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }


}