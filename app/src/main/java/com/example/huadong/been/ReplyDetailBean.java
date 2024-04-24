package com.example.huadong.been;

public class ReplyDetailBean {
    private String commentName,commentContent;
    private String nickName;//回复者名字
    private String userLogo;
    private int id;
    private String commentId;
    private String content;
    private String status;//地位
    private String createDate;

    public ReplyDetailBean(String nickName, String content,String commentName,String commentContent) {
        this.nickName = nickName;
        this.content = content;
        this.commentName= commentName;
        this.commentContent=commentContent;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getCommentId() {
        return commentId;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "ReplyDetailBean{" +
                "commentName='" + commentName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userLogo='" + userLogo + '\'' +
                ", id=" + id +
                ", commentId='" + commentId + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
