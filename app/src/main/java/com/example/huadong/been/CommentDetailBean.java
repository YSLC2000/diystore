package com.example.huadong.been;

import java.util.List;

public class CommentDetailBean {
    private int id;
    private String nickName;//分享订单的用户名
    private String userLogo;
    private String content;
    private String imgId;
    private int replyTotal;
    private String createDate;
    private String commentName;//评论者用户名

    private List<ReplyDetailBean> replyList;//回复者用户列表

    public String getCommentName() {
        return commentName;
    }
    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }
    public CommentDetailBean(String nickName,  String createDate) {
        this.nickName = nickName;
        this.createDate = createDate;
    }

    public CommentDetailBean(String nickName,  String content, String createDate,String commentName,List<ReplyDetailBean> replyDetailBeans) {
        this.nickName = nickName;
        this.content = content;
        this.createDate = createDate;
        this.commentName=commentName;
        this.replyList=replyDetailBeans;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return nickName;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }
    public String getUserLogo() {
        return userLogo;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
    public String getImgId() {
        return imgId;
    }

    public void setReplyTotal(int replyTotal) {
        this.replyTotal = replyTotal;
    }
    public int getReplyTotal() {
        return replyTotal;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }

    public void setReplyList(List<ReplyDetailBean> replyList) {
        this.replyList = replyList;
    }
    public List<ReplyDetailBean> getReplyList() {
        return replyList;
    }

    @Override
    public String toString() {
        return "CommentDetailBean{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userLogo='" + userLogo + '\'' +
                ", content='" + content + '\'' +
                ", imgId='" + imgId + '\'' +
                ", replyTotal=" + replyTotal +
                ", createDate='" + createDate + '\'' +
                ", replyList=" + replyList +
                ", commentName='" + commentName + '\'' +
                '}';
    }
}
