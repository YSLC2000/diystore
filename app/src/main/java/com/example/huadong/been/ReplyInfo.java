package com.example.huadong.been;

public class ReplyInfo {
    private int reply_id;
    private String comment_name;
    private String reply_name;
    private String replay_content;

    public ReplyInfo(int reply_id, String comment_name, String reply_name, String replay_content) {
        this.reply_id = reply_id;
        this.comment_name = comment_name;
        this.reply_name = reply_name;
        this.replay_content = replay_content;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public String getComment_name() {
        return comment_name;
    }

    public void setComment_name(String comment_name) {
        this.comment_name = comment_name;
    }

    public String getReply_name() {
        return reply_name;
    }

    public void setReply_name(String reply_name) {
        this.reply_name = reply_name;
    }

    public String getReplay_content() {
        return replay_content;
    }

    public void setReplay_content(String replay_content) {
        this.replay_content = replay_content;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "reply_id=" + reply_id +
                ", comment_name='" + comment_name + '\'' +
                ", reply_name='" + reply_name + '\'' +
                ", replay_content='" + replay_content + '\'' +
                '}';
    }
}
