package com.example.huadong.been;

public class CommentInfo {
     private int comment_id;
     private String user_name;
     private String share_name;
     private int part_img;
      private String share_time;
     private String comment_time;
     private String comment_name;
     private String comment_content;

     public CommentInfo(){

     }

    public CommentInfo(int comment_id, String user_name, String share_name, int part_img, String share_time, String comment_time, String comment_name, String comment_content) {
        this.comment_id = comment_id;
        this.user_name = user_name;
        this.share_name = share_name;
        this.part_img = part_img;
        this.share_time = share_time;
        this.comment_time = comment_time;
        this.comment_name = comment_name;
        this.comment_content = comment_content;
    }
    public CommentInfo(String user_name, String share_name, String share_time, String comment_time, String comment_name, String comment_content) {
        this.user_name = user_name;
        this.share_name = share_name;
        this.share_time = share_time;
        this.comment_time = comment_time;
        this.comment_name = comment_name;
        this.comment_content = comment_content;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getShare_name() {
        return share_name;
    }

    public void setShare_name(String share_name) {
        this.share_name = share_name;
    }

    public int getPart_img() {
        return part_img;
    }

    public void setPart_img(int part_img) {
        this.part_img = part_img;
    }

    public String getShare_time() {
        return share_time;
    }

    public void setShare_time(String share_time) {
        this.share_time = share_time;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_name() {
        return comment_name;
    }

    public void setComment_name(String comment_name) {
        this.comment_name = comment_name;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "comment_id=" + comment_id +
                ", user_name='" + user_name + '\'' +
                ", share_name='" + share_name + '\'' +
                ", part_img=" + part_img +
                ", share_time='" + share_time + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", comment_name='" + comment_name + '\'' +
                ", comment_content='" + comment_content + '\'' +
                '}';
    }
}
