package me.gacl.domain;

import java.util.ArrayList;
import java.util.Date;

public class Blog {
    public String blogId;
    public String blogName;
    public String blogAuthor;
    public ArrayList<Tag> blogTags;
    public Date blogTime;
    public String blogLevel;
    public ArrayList<Comment> blogcomments;
    public User Author;
    public int blogVisit;
    public String blogClass;

    public String getBlogClass() {
        return blogClass;
    }

    public void setBlogClass(String blogClass) {
        this.blogClass = blogClass;
    }

    public int getBlogVisit() {
        return blogVisit;
    }

    public void setBlogVisit(int blogVisit) {
        this.blogVisit = blogVisit;
    }

    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User author) {
        Author = author;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    public boolean isUserLike() {
        return userLike;
    }

    public void setUserLike(boolean userLike) {
        this.userLike = userLike;
    }

    public String blogReprint;
    public String blogIndex;
    public int likesNum;
    public boolean userLike;

    public String getBlogIndex() {
        return blogIndex;
    }

    public void setBlogIndex(String blogIndex) {
        this.blogIndex = blogIndex;
    }

    public String getBlogReprint() {
        return blogReprint;
    }

    public void setBlogReprint(String blogReprint) {
        this.blogReprint = blogReprint;
    }

    public ArrayList<Comment> getBlogcomments() {
        return blogcomments;
    }

    public void setBlogcomments(ArrayList<Comment> blogcomments) {
        this.blogcomments = blogcomments;
    }

    public String getBlogLevel() {
        return blogLevel;
    }

    public ArrayList<Tag> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(ArrayList<Tag> blogTags) {
        this.blogTags = blogTags;
    }

    public void setBlogLevel(String blogLevel) {
        this.blogLevel = blogLevel;
    }

    public String getBlogMd() {
        return blogMd;
    }

    public void setBlogMd(String blogMd) {
        this.blogMd = blogMd;
    }

    public String blogAttribute;
    public String blogText;
    public String blogAuthorId;
    public String blogMd;

    public Blog(String blogId, String blogName, String blogAuthor, Date blogTime, String blogAttribute, String blogText, String blogAuthorId) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogAuthor = blogAuthor;
        this.blogTime = blogTime;
        this.blogAttribute = blogAttribute;
        this.blogText = blogText;
        this.blogAuthorId = blogAuthorId;
    }

    public Blog() {

    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public void setBlogTime(Date blogTime) {
        this.blogTime = blogTime;
    }

    public void setBlogAttribute(String blogAttribute) {
        this.blogAttribute = blogAttribute;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public void setBlogAuthorId(String blogAuthorId) {
        this.blogAuthorId = blogAuthorId;
    }

    public String getBlogId() {
        return blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public Date getBlogTime() {
        return blogTime;
    }

    public String getBlogAttribute() {
        return blogAttribute;
    }

    public String getBlogText() {
        return blogText;
    }

    public String getBlogAuthorId() {
        return blogAuthorId;
    }
}
