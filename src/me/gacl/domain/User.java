package me.gacl.domain;

import java.util.ArrayList;
import java.util.Date;

public class User {
    public String id;
    public String pawd;
    public String name;
    public int sex;
    public Date birthday;
    public String email;
    public String sayings;
    public String head;
    public int administrator;
    public String telOremail;

    public String getTelOremail() {
        return telOremail;
    }

    public void setTelOremail(String telOremail) {
        this.telOremail = telOremail;
    }

    public ArrayList<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(ArrayList<Blog> blogs) {
        this.blogs = blogs;
    }

    public ArrayList<Blog> blogs=new ArrayList<>();

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public String text;
    public int status;

    public void setId(String id) {
        this.id = id;
    }

    public void setPawd(String pawd) {
        this.pawd = pawd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSayings(String sayings) {
        this.sayings = sayings;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }

    public String getId() {
        return id;
    }

    public String getPawd() {
        return pawd;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getSayings() {
        return sayings;
    }

    public String getHead() {
        return head;
    }

    public int getAdministrator() {
        return administrator;
    }
}
