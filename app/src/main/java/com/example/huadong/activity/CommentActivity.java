package com.example.huadong.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.example.huadong.been.ReplyDetailBean;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity{
    private CommentExpandAdapt commentExpandAdapt;
    private ExpandableListView expandableListView;
    private CommentBean commentBean;
    private List<CommentDetailBean> list =new ArrayList<>();
    private BottomSheetDialog dialog;
    private TextView textView,content,share;
    private ImageView imageView;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        expandableListView =findViewById(R.id.comment_list);
        CommentDetailBean commentBean1 =new CommentDetailBean("小明","你还是","不久前");
        CommentDetailBean commentBean2 =new CommentDetailBean("小芳","不是我","不久前");
        CommentDetailBean commentBean4 =new CommentDetailBean("芜湖","密斯卡","莫斯卡");
        CommentDetailBean commentBean3 =new CommentDetailBean("是我","还是我","不久前");
        CommentDetailBean commentBean5 =new CommentDetailBean("还好","还是我","不久前");
        list.add(commentBean1);
        list.add(commentBean2);
        list.add(commentBean4);
        list.add(commentBean3);
        list.add(commentBean5);
        initExpandableListView(list);
        textView=findViewById(R.id.textView9);
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
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentDialog();
            }
        });
        imageView=findViewById(R.id.imageView4);
        content=findViewById(R.id.textView10);
        content.setText("这是一些测试数据这是一些测试数据这是一些测试数据这是一些测试数据这是一些测试数据这是一些测试数据");
        imageView.setImageResource(R.drawable.display_user_img_gwen);

    }



    private void initExpandableListView( List<CommentDetailBean> commentList){
        expandableListView.setGroupIndicator(null);
        expandableListView.setDivider(null);
        //默认展开所有回复
        commentExpandAdapt = new CommentExpandAdapt(this, commentList);
        expandableListView.setAdapter(commentExpandAdapt);
        for(int i = 0; i<commentList.size(); i++){
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d("CommentActivity",commentList.get(groupPosition).getId()+"");
//                if(isExpanded){
//                    expandableListView.collapseGroup(groupPosition);
//                }else {
//                    expandableListView.expandGroup(groupPosition, true);
//                }
                 showReplyDialog(groupPosition);
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
        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
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
                    dialog.dismiss();
                    CommentDetailBean detailBean = new CommentDetailBean("小明", "你还是","不久前");
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
        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        commentText.setHint("回复 " + list.get(position).getNickName() + " 的评论:");
        dialog.setContentView(commentView);
        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replyContent = commentText.getText().toString().trim();
                if(!TextUtils.isEmpty(replyContent)){
                    dialog.dismiss();
                    ReplyDetailBean detailBean = new ReplyDetailBean("小红",replyContent);
                    commentExpandAdapt.addTheReplyData(detailBean, position);
                    expandableListView.expandGroup(position);
                    Toast.makeText(CommentActivity.this,"回复成功",Toast.LENGTH_SHORT).show();
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