package me.gacl.domain;

import java.util.ArrayList;
import java.util.Date;

public class Comment {
    public String commentId;
    public String commentText;
    public Date commentTime;
    public String commentUser;
    public String commentBlogid;
    public String userHead;
    public String userName;
    public int commentLevel;
    public String recommentId;

    public ArrayList<Comment> getRecommentList() {
        return recommentList;
    }

    public void setRecommentList(ArrayList<Comment> recommentList) {
        this.recommentList = recommentList;
    }

    public ArrayList<Comment> recommentList;

    public int getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(int commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getRecommentId() {
        return recommentId;
    }

    public void setRecommentId(String recommentId) {
        this.recommentId = recommentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    public String getCommentBlogid() {
        return commentBlogid;
    }

    public void setCommentBlogid(String commentBlogid) {
        this.commentBlogid = commentBlogid;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
