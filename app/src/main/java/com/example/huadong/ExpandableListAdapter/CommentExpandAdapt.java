package com.example.huadong.ExpandableListAdapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.huadong.R;
import com.example.huadong.been.CommentDetailBean;
import com.example.huadong.been.ReplyDetailBean;
import com.example.huadong.been.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class CommentExpandAdapt extends BaseExpandableListAdapter {
    private Context context;
    private List<CommentDetailBean> list;
    public CommentExpandAdapt(Context context, List<CommentDetailBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(list.get(groupPosition).getReplyList() == null){
            return 0;
        }else {
            return list.get(groupPosition).getReplyList().size() > 0 ? list.get(groupPosition).getReplyList().size() : 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        //返回group的实际数据，这里指的是当前评论数据。

        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //返回group中某个child的实际数据，这里指的是当前评论的某个回复数据
        return list.get(groupPosition).getReplyList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        //返回分组的id，一般将当前group的位置传给它。
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        //返回分组中某个child的id，一般也将child当前位置传给它
        return getCombinedChildId(groupPosition,groupPosition);
    }

    @Override
    public boolean hasStableIds() {
        //表示分组和子选项是否持有稳定的id，这里返回true即可。
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //即返回group的视图，一般在这里进行一些数据和视图绑定的工作，一般为了复用和高效，可以自定义ViewHolder，用法与listview一样，这里就不多说了。
        GroupView groupView;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.expand_comment_item,parent,false);
            groupView= new GroupView(convertView);
            convertView.setTag(groupView);
        }else{
            groupView = (GroupView) convertView.getTag();
        }
        CommentDetailBean commentDetailBean1 = list.get(groupPosition);
        Log.d("commentDetailBean1",commentDetailBean1.toString());

        groupView.tv_name.setText(commentDetailBean1.getCommentName());
        groupView.tv_content.setText(commentDetailBean1.getContent());
        groupView.tv_time.setText("2024/4/24");
        groupView.imageView.setImageResource(R.drawable.display_user_img_gwen);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //返回分组中child子项的视图，比较容易理解，第一个参数是当前group所在的位置，第二个参数是当前child所在位置。
        ChildView childView;
        if(convertView==null){
            convertView =LayoutInflater.from(context).inflate(R.layout.expand_comment_reply_item,parent,false);
            childView = new ChildView(convertView);
            convertView.setTag(childView);
        }else{
            childView =(ChildView) convertView.getTag();
        }
            String replayName = list.get(groupPosition).getReplyList().get(childPosition).getNickName();
        Log.d("replayName",replayName);
        Log.d("replayName",list.toString());
        if(!TextUtils.isEmpty(replayName)){
            childView.tv_name.setText(replayName);
        }else {
            childView.tv_name.setText("无名");
        }
        List<ReplyDetailBean> replyDetailBean = list.get(groupPosition).getReplyList();
        Log.d("commentDetailBean",replyDetailBean.toString());
//        childView.tv_name.setText(list.get(groupPosition).getReplyList().get(childPosition).getNickName());
//        childView.tv_content.setText(list.get(groupPosition).getReplyList().get(childPosition).getContent());
        childView.tv_name.setText(replyDetailBean.get(childPosition).getCommentName());
        childView.tv_content.setText(replyDetailBean.get(childPosition).getCommentContent());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        //表示分组中的child是否可以选中，这里返回true。
        return true;
    }
    public  class GroupView  {
        private final TextView tv_name;
        private final TextView tv_content;
        private TextView tv_time;
        private ImageView imageView;

        public GroupView(View view) {
            imageView = view.findViewById(R.id.item_img);
            tv_content = (TextView) view.findViewById(R.id.item_data);
            tv_name = (TextView) view.findViewById(R.id.item_name);
            tv_time = (TextView) view.findViewById(R.id.item_time);
//            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView2);
        }
        public void bindData(CommentDetailBean commentDetailBean){

        }
    }
    public  class ChildView{
        private TextView tv_name, tv_content;
        public ChildView(View view){
            tv_name = (TextView) view.findViewById(R.id.reply_item_user);
            tv_content = (TextView) view.findViewById(R.id.reply_item_content);
        }

    }
    /**
     * by moos on 2018/04/20
     * func:评论成功后插入一条数据
     * @param commentDetailBean 新的评论数据
     */
    public void addTheCommentData(CommentDetailBean commentDetailBean){
        if(commentDetailBean!=null){
            list.add(commentDetailBean);
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("评论数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:回复成功后插入一条数据
     * @param replyDetailBean 新的回复数据
     */
    public void addTheReplyData(ReplyDetailBean replyDetailBean, int groupPosition){
        if(replyDetailBean!=null){
            Log.d("expandAdapt","addTheReplyData: >>>>该刷新回复列表了:"+replyDetailBean.getCommentContent());
            if(list.get(groupPosition).getReplyList() != null ){
                list.get(groupPosition).getReplyList().add(replyDetailBean);
            }else {
                List<ReplyDetailBean> replyList = new ArrayList<>();
                replyList.add(replyDetailBean);
                list.get(groupPosition).setReplyList(replyList);
            }
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("回复数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:添加和展示所有回复
     * @param replyBeanList 所有回复数据
     * @param groupPosition 当前的评论
     */
    private void addReplyList(List<ReplyDetailBean> replyBeanList, int groupPosition){
        if(list.get(groupPosition).getReplyList() != null ){
            list.get(groupPosition).getReplyList().clear();
            list.get(groupPosition).getReplyList().addAll(replyBeanList);
        }else {

            list.get(groupPosition).setReplyList(replyBeanList);
        }

        notifyDataSetChanged();
    }
}
